import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.net.URL;
//import java.util.Calendar;
//import java.util.GregorianCalendar;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
//import javax.speech.Central;
//import javax.speech.synthesis.Synthesizer;

public class Sentence
{
	public String sentence;
	public String[] words = null;
	public Word[] word = null;
	public int wcount;
	public String[] syllableBox; //final syllable sequence
	public int scount;
	public int pspitch, sspitch, uspitch;
	public int psv, ssv, usv; 
	public Rhythm rhythm;
	public int[] template; //odd ones are the numbers of the unstressed syllables between the stressed syllables and the even ones are the numbers of the stressed syllables (primary:1 and secondary:2) of content words
	public String CMUpath, FWLpath;
	
	public Sentence(String CMUp, String FWLp, String s, int pitch1, int pitch2, int pitch0 , int psVolume, int ssVolume, int usVolume, int inM, int measure) throws Exception
	{
		CMUpath = CMUp;
		FWLpath = FWLp;
		scount = 0;
		sentence = s;
		words = sentence.split(" ");
		wcount = words.length;
		//pitch = note;
		psv = psVolume;
		ssv = ssVolume;
		usv = usVolume;
		/*int l = words[wcount - 1].length();
		while(!Character.isLetter(words[wcount - 1].charAt(l - 1)))
		{
			words[wcount - 1] = words[wcount - 1].substring(0, l - 1);
			l = words[wcount - 1].length();		
		}*/
		word = new Word[wcount];
		for(int i = 0; i < wcount; i++)
		{
			word[i] = new Word();
			word[i].word = words[i].trim();
			int l = word[i].word.length();
			//get rid of the punctuations following a word
			while(!Character.isLetter(word[i].word.charAt(l - 1)))
			{
				word[i].word = word[i].word.substring(0, l - 1);
				l = word[i].word.length();
				word[i].punctuation = true;
			}
			word[i].getPronouciation(CMUpath);
			word[i].getStressed(FWLpath);
			scount += word[i].syllables.length;//find the syllable count in the sentence
			/*for(int j = 0; j < word[i].syllables.length; j++)
				System.out.print(word[i].syllables[j] + " ");
			System.out.println();*/
		}
		//System.out.println("Pitch: " + pitch);
		System.out.println("SPEED:");
		System.out.println("Incomplete measure: " + inM + "  measure : " + measure);
		System.out.println("VOLUME:");
		System.out.println("Pri stress: " + psv + "  Sec stress : " + ssv + "  Unstress: " + usv);
		
		syllableBox = new String[scount];
		//System.out.println("NOTE! " + scount);
		//System.out.println("NOTE2! " + syllableBox.length);
		
		getRhythm(inM, measure);
		//playmidi(rhythm);
	}
	
	public void updateSetting(int pitch1, int pitch2, int pitch0, int psVolume, int ssVolume, int usVolume, int init, int measure)
	{
		pspitch = pitch1;
		sspitch = pitch2;
		uspitch = pitch0;
		psv = psVolume;
		ssv = ssVolume;
		usv = usVolume;
		//System.out.println("Pitch: " + pitch);
		System.out.println("SPEED:");
		System.out.println("Incomplete measure: " + init + "  measure : " + measure);
		System.out.println("VOLUME:");
		System.out.println("Pri stress: " + psv + "  Sec stress : " + ssv + "  Unstress: " + usv);
		getRhythm(init, measure);
	}
	
	public void getRhythm(int inM, int measure)
	{
		rhythm = new Rhythm(scount);
		
		//odd ones are the numbers of the unstressed syllables between the stressed syllables and the even ones are the numbers of the stressed syllables (primary:1 and secondary:2) of content words
		//int[] template;
		
		//To copy the syllables from each word into syllableBox for further operation
		//give unstress to stressed syllables of function words
		for(int i = 0, sn = 0; i < wcount; i++)
		{
			if(word[i].stressed == true)
			{
				for(int j = 0; j < word[i].syllables.length; j++)
					syllableBox[sn++] = word[i].syllables[j];
			}
			else
			{
				for(int j = 0; j < word[i].syllables.length; j++)
					syllableBox[sn++] = "0";
			}
		}
		
		/*for(int i = 0, k = 0; i < wcount; i++)
			for(int j = 0; j < word[i].syllables.length; j++, k++)
				syllableBox[k] = word[i].syllables[j];*/
		
		
		//System.out.println("stressShift!");
		stressShift();
		//System.out.println("stressDeletion!");
		stressDeletion();
		//System.out.println("stressAddition!");
		stressAddition();
		
		System.out.println("SyllableBox:");
		for(int i = 0; i < syllableBox.length; i++)
			System.out.print(syllableBox[i] + " ");
		System.out.println();
		
		//find the total number of stressed syllables in the sentence
		int sscount = 0;
		for(int i = 0; i < syllableBox.length; i++)
			if(syllableBox[i].equals("1") || syllableBox[i].equals("2"))
				sscount++;
		System.out.println("stressed syllable count: " + sscount);
		/*for(int i = 0; i < wcount; i++)
			if(word[i].stressed == true)
				for(int j = 0; j < word[i].syllables.length; j++)
					if(!word[i].syllables[j].equalsIgnoreCase("0"))
						sscount++;*/
		//System.out.println("Dara: " + sscount);
		
		template = new int[2 * sscount + 1];
		int sn = 0;//the position in the syllableBox    //syllable number between the stressed syllables
		int tn = 0;//the position in the template
		for(; tn < template.length; tn++)
		{
			template[tn] = 0; //initialize the number of unstressed syllables in template
			for(; sn < syllableBox.length; sn++)
				if(tn % 2 == 0)
					if(syllableBox[sn].equals("0"))
						template[tn]++;
					else
						break;
				else
				{
					template[tn] = Integer.parseInt(syllableBox[sn]);
					sn++;
					break;
				}
		}
		/*
		for(int i = 0; i < wcount; i++)
		{
			if(word[i].stressed == true)
				for(int j = 0; j < word[i].syllables.length; j++)
				{
					//sc++;
					if(word[i].syllables[j].equalsIgnoreCase("1"))
					{
						template[tn++] = sn;
						template[tn++] = 1;
						sn = 0;
					}
					else
						if(word[i].syllables[j].equalsIgnoreCase("2"))
						{
							template[tn++] = sn;
							template[tn++] = 2;
							sn = 0;
						}
					    else
							sn++;
				}
			else
				for(int j = 0; j < word[i].syllables.length; j++)
				{
					//sc++;
					sn++;
				}
		}
		*/
		//template[tn] = sn;
		System.out.println("TEMPLATE:");
		for(int i = 0; i < 2 * sscount + 1; i++)
			System.out.print(template[i] + " ");
		System.out.println();
		int sc = -1;//syllable count
		for(int i = 0; i < template.length; i++)
		{
			if(i % 2 == 0)
			{
				for(int j = 0; j < template[i]; j++)
				{
					if(template[i] == 0)
						break;
					sc++;
					if(i == 0)
					{
						if(template[i + 1] == 1)//case1 0h 1 0...
						{
							rhythm.length[sc] = inM / template[i];
							rhythm.volume[sc] = usv;
							rhythm.note[sc] = uspitch;
							continue;
						}
						if(template[i + 1] == 2)//case2 0h 2 0 1 0...
						{
							int temp1 = template[i] + template[i + 2];
							if(temp1 == 1)
							{
								rhythm.length[sc] = inM * 2 / 5;
								rhythm.volume[sc] = usv;
								rhythm.note[sc] = uspitch;
							}
							else
							{
								rhythm.length[sc] = (inM - (inM / temp1)) / temp1;
								rhythm.volume[sc] = usv;
								rhythm.note[sc] = uspitch;							
							}
							continue;
						}							
					}
					else if(i == 2 && template[i - 1] == 2)//case3 0 2 0h 1 0...
					{
						int temp1 = template[i] + template[i - 2];
						if(temp1 == 1)
						{
							rhythm.length[sc] = inM * 2 / 5;
							rhythm.volume[sc] = usv;
							rhythm.note[sc] = uspitch;
						}
						else	
						{
							rhythm.length[sc] = (inM - (inM / temp1)) / temp1;
							rhythm.volume[sc] = usv;
							rhythm.note[sc] = uspitch;
						}
						continue;
					}
					else if(i == template.length - 1)
					{
						if(template[i - 1] == 1)//case4 ...1 0h
						{
							if(template[i] == 1)
							{
								rhythm.length[sc] = measure * 2 / 5;
								rhythm.volume[sc] = usv;
								rhythm.note[sc] = uspitch;
							}
							else	
							{
								rhythm.length[sc] = (measure - (measure / template[i])) / template[i];
								rhythm.volume[sc] = usv;
								rhythm.note[sc] = uspitch;
							}
							continue;
						}
						if(template[i - 1] == 2)//case5 ...1 0 2 0h
						{
							int temp1 = template[i - 2] + template[i];
							int temp2 = temp1 + 1;
							int temp3 = temp1 + 2;
							rhythm.length[sc] = (measure - (measure / temp2) - (measure / temp3)) / temp1;
							rhythm.volume[sc] = usv;
							rhythm.note[sc] = uspitch;
							continue;
						}
					}
					else if(i == template.length - 3 && template[i + 1] == 2)//case6 ...1 0h 2 0
					{
						int temp1 = template[i] + template[i + 2];
						int temp2 = temp1 + 1;
						int temp3 = temp1 + 2;
						rhythm.length[sc] = (measure - (measure / temp2) - (measure / temp3)) / temp1;
						rhythm.volume[sc] = usv;
						rhythm.note[sc] = uspitch;
						continue;
					}
					else if(template[i - 1] == 1 && template[i + 1] == 1)//case7 ...1 0h 1...
					{
						if(template[i] == 1)
						{
							rhythm.length[sc] = measure * 2 / 5;
							rhythm.volume[sc] = usv;
							rhythm.note[sc] = uspitch;
						}
						else	
						{
							rhythm.length[sc] = (measure - (measure / template[i])) / template[i];
							rhythm.volume[sc] = usv;
							rhythm.note[sc] = uspitch;
						}
						continue;
					}
					else if(template[i - 1] == 1 && template[i + 1] == 2 && template[i + 3] == 1)//case8 ...1 0h 2 0 1...
					{
						int temp1 = template[i] + template[i + 2];
						int temp2 = temp1 + 1;
						int temp3 = temp1 + 2;
						rhythm.length[sc] = (measure - (measure / temp2) - (measure / temp3)) / temp1;
						rhythm.volume[sc] = usv;
						rhythm.note[sc] = uspitch;
						continue;
					}
					else if(template[i - 3] == 1 && template[i - 1] == 2 && template[i + 1] == 1)//case9 ...1 0 2 0h 1...
					{
						int temp1 = template[i - 2] + template[i];
						int temp2 = temp1 + 1;
						int temp3 = temp1 + 2;
						rhythm.length[sc] = (measure - (measure / temp2) - (measure / temp3)) / temp1;
						rhythm.volume[sc] = usv;
						rhythm.note[sc] = uspitch;
						continue;					
					}
					else if(template[i - 1] == 1 && template[i + 1] == 2 && template[i + 3] == 2 && template[i + 5] == 1)//case10 ...1 0h 2 0 2 0 1...
					{
						int temp1 = template[i] + template[i + 2] + template[i + 4];
						int temp2 = temp1 + 2;
						int temp3 = temp1 + 3;
						rhythm.length[sc] = (measure - (measure / temp2) - (measure / temp3) * 2) / temp1;
						rhythm.volume[sc] = usv;
						rhythm.note[sc] = uspitch;
						continue;
					}
					else if(template[i - 3] == 1 && template[i - 1] == 2 && template[i + 1] == 2 && template[i + 3] == 1)//case11 ...1 0 2 0h 2 0 1...
					{
						int temp1 = template[i - 2] + template[i] + template[i + 2];
						int temp2 = temp1 + 2;
						int temp3 = temp1 + 3;
						rhythm.length[sc] = (measure - (measure / temp2) - (measure / temp3) * 2) / temp1;
						rhythm.volume[sc] = usv;
						rhythm.note[sc] = uspitch;
						continue;					
					}
					else if(template[i - 5] == 1 && template[i - 3] == 2 && template[i - 1] == 2 && template[i + 1] == 1)//case12 ...1 0 2 0 2 0h 1...
					{
						int temp1 = template[i - 4] + template[i - 2] + template[i];
						int temp2 = temp1 + 2;
						int temp3 = temp1 + 3;
						rhythm.length[sc] = (measure - (measure / temp2) - (measure / temp3) * 2) / temp1;
						rhythm.volume[sc] = usv;
						rhythm.note[sc] = uspitch;
						continue;					
					}
				}
			}
			else
			{
				sc++;
				if(i == 1 && template[1] == 2)//case1 0 2h 0 1...
				{
					int temp1 = template[i - 1] + template[i + 1];
					if(temp1 == 0)
					{
						rhythm.length[sc] = inM;
					}
					else if(temp1 == 1)
					{
						rhythm.length[sc] = inM * 3 / 5;					
					}
					else
					{
						rhythm.length[sc] = inM / temp1;				
					}
					rhythm.volume[sc] = ssv;
					rhythm.note[sc] = sspitch;
					continue;
				}
				else if(i == template.length - 2 && template[i] == 1)//case2 ...1h 0
				{
					if(template[i + 1] == 0)
					{
						rhythm.length[sc] = measure;
					}
					else if(template[i + 1] == 1)
					{
						rhythm.length[sc] = measure * 3 / 5;
					}
					else	
					{
						rhythm.length[sc] = measure / template[i + 1];
					}
					rhythm.volume[sc] = psv;
					rhythm.note[sc] = pspitch;
					continue;					
				}
				else if(i == template.length - 2 && template[i] == 2)//case3 ...1 0 2h 0
				{
					int temp1 = template[i - 1] + template[i + 1];
					//int temp2 = temp1 + 1;
					int temp3 = temp1 + 2;
					if(temp1 == 0)
					{
						rhythm.length[sc] = measure * 2 / 5;
					}
					else
					{
						rhythm.length[sc] = measure / temp3;
					}			
					rhythm.volume[sc] = ssv;
					rhythm.note[sc] = sspitch;
					continue;
				}
				else if(i == template.length - 4 && template[i] == 1 && template[i + 2] == 2)//case4 ...1h 0 2 0
				{
					int temp1 = template[i + 1] + template[i + 3];
					int temp2 = temp1 + 1;
					//int temp3 = temp1 + 2;
					if(temp1 == 0)
					{
						rhythm.length[sc] = measure * 3 / 5;
					}
					else
					{
						rhythm.length[sc] = measure / temp2;
					}
					rhythm.volume[sc] = psv;
					rhythm.note[sc] = pspitch;
					continue;			
				}
				else if(template[i] == 1 && template[i + 2] == 1)//case5 ...1h 0 1...
				{
					if(template[i + 1] == 0)
					{
						rhythm.length[sc] = measure;
					}
					else if(template[i + 1] == 1)
					{
						rhythm.length[sc] = measure * 3 / 5;
					}
					else	
					{
						rhythm.length[sc] = measure / template[i + 1];
					}
					rhythm.volume[sc] = psv;
					rhythm.note[sc] = pspitch;
					continue;
				}
				else if(template[i] == 1 && template[i + 2] == 2 && template[i + 4] == 1)//case6 ...1h 0 2 0 1...
				{
					int temp1 = template[i + 1] + template[i + 3];
					int temp2 = temp1 + 1;
					//int temp3 = temp1 + 2;
					if(temp1 == 0)
					{
						rhythm.length[sc] = measure * 3 / 5;
					}
					else
					{
						rhythm.length[sc] = measure / temp2;
					}
					rhythm.volume[sc] = psv;
					rhythm.note[sc] = pspitch;
					continue;
				}
				else if(template[i] == 1 && template[i + 2] == 2 && template[i + 4] == 2 && template[i + 6] == 1)//case8 ...1h 0 2 0 2 0 1...
				{
					int temp1 = template[i + 1] + template[i + 3] + template[i + 5];
					int temp2 = temp1 + 2;
					//int temp3 = temp1 + 3;
					if(temp1 == 0)
					{
						rhythm.length[sc] = measure * 2 / 5;
					}
					else
					{
						rhythm.length[sc] = measure / temp2;
					}
					rhythm.volume[sc] = psv;
					rhythm.note[sc] = pspitch;
					continue;
				}
				else if(template[i - 2] == 1 && template[i] == 2 && template[i + 2] == 1)//case7 ...1 0 2h 0 1...
				{
					int temp1 = template[i - 1] + template[i + 1];
					//int temp2 = temp1 + 1;
					int temp3 = temp1 + 2;
					if(temp1 == 0)
					{
						rhythm.length[sc] = measure * 2 / 5;
					}
					else
					{
						rhythm.length[sc] = measure / temp3;
					}			
					rhythm.volume[sc] = ssv;
					rhythm.note[sc] = sspitch;
					continue;
				}
				else if(template[i - 2] == 1 && template[i] == 2 && template[i + 2] == 2 && template[i + 4] == 1)//case9 ...1 0 2h 0 2 0 1...
				{
					int temp1 = template[i - 1] + template[i + 1] + template[i + 3];
					//int temp2 = temp1 + 2;
					int temp3 = temp1 + 3;
					if(temp1 == 0)
					{
						rhythm.length[sc] = measure * 3 / 10;
					}
					else
					{
						rhythm.length[sc] = measure / temp3;
					}
					rhythm.volume[sc] = ssv;
					rhythm.note[sc] = sspitch;
					continue;
				}
				else if(template[i - 4] == 1 && template[i - 2] == 2 && template[i] == 2 && template[i + 2] == 1)//case10 ...1 0 2 0 2h 0 1...
				{
					int temp1 = template[i - 3] + template[i - 1] + template[i + 1];
					//int temp2 = temp1 + 2;
					int temp3 = temp1 + 3;
					if(temp1 == 0)
					{
						rhythm.length[sc] = measure * 3 / 10;
					}
					else
					{
						rhythm.length[sc] = measure / temp3;
					}
					rhythm.volume[sc] = ssv;
					rhythm.note[sc] = sspitch;
					continue;
				}
			}
		}
		
		System.out.println("LENGTH OF EACH SYLLABLE:");	
		for(int i = 0; i < scount; i++)
		{
			System.out.print(rhythm.length[i] + " ");
		}
		System.out.println();
		System.out.println("VOLUME OF EACH SYLLABLE:");	
		for(int i = 0; i < scount; i++)
		{
			System.out.print(rhythm.volume[i] + " ");
		}
		System.out.println();
		System.out.println();
	}
	
	//Doing the stress shift operation  ONGOING
	private void stressShift() //length, volume, note
	{
		int mark0 = 0, mark1 = 0;
		do
		{
			mark0 = mark1;
			for(int i = 0; i < syllableBox.length; i++)
			{
				//if(i + 5 < rhythm.volume.length)
				if(i + 5 < syllableBox.length)
					//Case1: ps ps ss us ps ps -> ps ps ps us us ps
					if(syllableBox[i].equals("1") && syllableBox[i + 1].equals("1") && syllableBox[i + 2].equals("2") && syllableBox[i + 3].equals("0") && syllableBox[i + 4].equals("1") && syllableBox[i + 5].equals("1"))
					{
						syllableBox[i + 2] = "1";
						syllableBox[i + 3] = "0";
						syllableBox[i + 4] = "0";
						mark1++;
						continue;
					}
					//Case2: ps ps us ss ps ps -> ps us us ps ps ps
					//else if(rhythm.volume[i] == psv && rhythm.volume[i + 1] == psv && rhythm.volume[i + 2] == usv && rhythm.volume[i + 3] == ssv && rhythm.volume[i + 4] == psv && rhythm.volume[i + 5] == psv)
					else if(syllableBox[i].equals("1") && syllableBox[i + 1].equals("1") && syllableBox[i + 2].equals("0") && syllableBox[i + 3].equals("2") && syllableBox[i + 4].equals("1") && syllableBox[i + 5].equals("1"))
					{
						syllableBox[i + 1] = "0";
						syllableBox[i + 2] = "0";
						syllableBox[i + 3] = "1";
						mark1++;
						continue;						
					}
				if(i + 2 < syllableBox.length)
					//Case3: ps ps ss -> ps us ps	
					//if(rhythm.volume[i] == psv && rhythm.volume[i + 1] == psv && rhythm.volume[i + 2] == ssv)
					if(syllableBox[i].equals("1") && syllableBox[i + 1].equals("1") && syllableBox[i + 2].equals("2"))
					{
						syllableBox[i + 1] = "0";
						syllableBox[i + 2] = "1";
						//rhythm.volume[i + 1] = usv;
						//rhythm.volume[i + 2] = psv;
						mark1++;
						continue;
					}
					//Case4: ss ps ps -> ps ss ps	
					//else if(rhythm.volume[i] == ssv && rhythm.volume[i + 1] == psv && rhythm.volume[i + 2] == psv)
					else if(syllableBox[i].equals("2") && syllableBox[i + 1].equals("1") && syllableBox[i + 2].equals("2"))
					{
						syllableBox[i] = "1";
						syllableBox[i + 1] = "0";
						//rhythm.volume[i] = psv;
						//rhythm.volume[i + 1] = usv;
						mark1++;
						continue;
					}
				if(i + 3 < syllableBox.length)
					//Case5: ps ps us ss -> ps us us ps	
					//if(rhythm.volume[i] == psv && rhythm.volume[i + 1] == psv && rhythm.volume[i + 2] == usv && rhythm.volume[i + 3] == ssv)
					if(syllableBox[i].equals("1") && syllableBox[i + 1].equals("1") && syllableBox[i + 2].equals("0") && syllableBox[i + 2].equals("2"))	
					{
						syllableBox[i + 1] = "0";
						syllableBox[i + 2] = "0";
						syllableBox[i + 3] = "1";
						//rhythm.volume[i + 1] = usv;
						//rhythm.volume[i + 2] = usv;
						//rhythm.volume[i + 3] = psv;
						mark1++;
						continue;
					}
					//Case6: ss us ps ps -> ps us us ps	
					//else if(rhythm.volume[i] == ssv && rhythm.volume[i + 1] == usv && rhythm.volume[i + 2] == psv && rhythm.volume[i + 3] == psv)
					else if(syllableBox[i].equals("1") && syllableBox[i + 1].equals("1") && syllableBox[i + 2].equals("0") && syllableBox[i + 2].equals("2"))
					{
						syllableBox[i] = "1";
						syllableBox[i + 1] = "0";
						syllableBox[i + 2] = "0";
						//rhythm.volume[i] = psv;
						//rhythm.volume[i + 1] = usv;
						//rhythm.volume[i + 2] = usv;
						mark1++;
						continue;
					}
			}
		}
		while(mark0 != mark1);	
	}

	//Doing the stress deletion operation
	private void stressDeletion()
	{
		//System.out.println("SD starts!");
		int mark0 = 0, mark1 = 0;
		do
		{
			mark0 = mark1;
			//for(int i = 0; i < rhythm.volume.length; i++)
			for(int i = 0; i < syllableBox.length; i++)
			{
				//Case1: ps ps ps -> ps us ps	
				//if(i + 2 < rhythm.volume.length && rhythm.volume[i] == psv && rhythm.volume[i + 1] == psv && rhythm.volume[i + 2] == psv)
				if(i + 2 < syllableBox.length && syllableBox[i].equals("1") && syllableBox[i + 1].equals("1") && syllableBox[i + 2].equals("1"))
				{
					//rhythm.volume[i + 1] = usv;
					//syllableBox[i + 1].equals("0");
					syllableBox[i + 1] = "0";
					mark1++;
					continue;                                                                                                                                                                                                                                                                                                                                                                                                                
				}
				//Case2: (start) ps ps -> (start) ps us
				//if(i + 1 < rhythm.volume.length && rhythm.volume[i] == psv && rhythm.volume[i + 1] == psv)
				if(syllableBox.length >= 2 && syllableBox[0].equals("1") && syllableBox[1].equals("1"))
				{
					//rhythm.volume[i] = usv;
					//syllableBox[i].equals("0");
					syllableBox[1] = "0";
					mark1++;
					continue;
				}
				//Case3: ps ps -> ps us
				//if(i + 1 < rhythm.volume.length && rhythm.volume[i] == psv && rhythm.volume[i + 1] == psv)
				if(i + 1 < syllableBox.length && syllableBox[i].equals("1") && syllableBox[i + 1].equals("1"))
				{
					//rhythm.volume[i] = usv;
					//syllableBox[i].equals("0");
					syllableBox[i + 1] = "0";
					mark1++;
					continue;
				}
				//Case4: us us us ps ps -> us us us ps us
				if(i + 4 < syllableBox.length && syllableBox[i].equals("0") && syllableBox[i + 1].equals("0") && syllableBox[i + 2].equals("0") && syllableBox[i + 3].equals("1") && syllableBox[i + 4].equals("1"))
				{
					//rhythm.volume[i] = usv;
					//syllableBox[i].equals("0");
					syllableBox[i + 4] = "0";
					mark1++;
					continue;
				}
			}
		}
		while(mark0 != mark1);
		//System.out.println("SD ends!");
	}

	//Doing the stress addition operation
	private void stressAddition()
	{
		//Case: (start)us us us-> ps us us
		if(syllableBox.length >= 3 && syllableBox[0].equals("0") && syllableBox[1].equals("0") && syllableBox[2].equals("0"))
			syllableBox[0] = "1";
	}
	
	public void playmidi(Rhythm r)
	{
		try 
		{
			javax.sound.midi.Synthesizer synthesizer = MidiSystem.getSynthesizer();        
			synthesizer.open();   
			MidiChannel channel = synthesizer.getChannels()[0];      
			for (int i = 0; i < r.length.length; i++) //r.length.length
			{             
				channel.noteOn(r.note[i], r.volume[i]);
				try 
				{             
					Thread.sleep(r.length[i]);
				} 
				catch (InterruptedException e) 
				{              
					break;         
				} 
				finally 
				{        
					channel.noteOff(r.note[i]);  
				}
			}
		}
		catch (MidiUnavailableException e) 
		{
				e.printStackTrace();   
		}  
	}
	
	/*public static void main(String[] args) throws Exception
	{
		Sentence ts = new Sentence("Perfect! Congratulations!", 60, 100, 80, 50);//Congratulations! You really did a good job!
		for(int i = 0; i < ts.wcount; i++)
		{
			System.out.print(ts.word[i].phoneme[0] + " :");
			for(int j = 1; j < ts.word[i].phoneme.length; j++)
				System.out.print(" " + ts.word[i].phoneme[j]);
			System.out.println();
		}
		
	}*/
}

class Word
{
	public String word;
	public String[] phoneme;
	public String pron;
	//public String[] ss;
	public String[] syllables;
	//public int note;
	public boolean punctuation;//whether the word followed by some punctuation
	public boolean stressed;//whether the word is a content word
	
	public Word()
	{
		phoneme = null;
		//ss = null;
		syllables = null;
		pron = "";
		punctuation = false;
		stressed = true;
	}
	
	public void getPronouciation(String cmupath) throws Exception
	{
		String[] ssbox = new String[10];
		for(int i = 0; i < 10; i++)
			ssbox[i] = null;
		try//get the phonemes of the word, setting the font and all the syllables with their stress levels
		{
			phoneme = findWordInDict(cmupath).split(" ");
			pron = "<html><font size=\"5px\">";
			for(int i = 2, j = 0; i < phoneme.length; i++)
			{
				if(Character.toString(phoneme[i].charAt(phoneme[i].length() - 1)).equalsIgnoreCase("1"))
				{
					pron += "<strong><font color=red>" + phoneme[i] + "</font></strong>" + " ";
					ssbox[j] = "1";
					j++;
				}
				else
					if(Character.toString(phoneme[i].charAt(phoneme[i].length() - 1)).equalsIgnoreCase("0"))
					{
						pron += phoneme[i] + " ";
						ssbox[j] = "0";
						j++;
					}
					else
						if(Character.toString(phoneme[i].charAt(phoneme[i].length() - 1)).equalsIgnoreCase("2"))
						{
							pron += phoneme[i] + " ";
							ssbox[j] = "2";
							j++;
						}
						else
							pron += phoneme[i] + " ";
			}
			pron += "</font></html>";
			int count;
			for(count = 0; count < 10; count++)
			{
				if(ssbox[count] == null)
					break;
			}
			syllables = new String[count];
			for(int i = 0; i < count; i++)
				syllables[i] = ssbox[i];
		} catch (Exception e) {
			if(e.getMessage().equalsIgnoreCase("No matched word found!"))
				throw new Exception("The word " + word + " could not be found in the dictionary");
			// TODO Auto-generated catch block
			phoneme = null;
			e.printStackTrace();
		}
	}
	
	//figure out whether the word is a content word
	public void getStressed(String fwlpath) throws Exception
	{
		String Line = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(fwlpath))); 
		try 
		{
			while((Line = br.readLine())!= null) 
			{
				if (word.equalsIgnoreCase(Line.trim()))
				{
					stressed = false;
					break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Line = null;
			e.printStackTrace();
		}
		finally
		{
			br.close();
		}
	}
	
	//look the word up in the CMU Dictionary
	@SuppressWarnings("finally")
	private String findWordInDict(String cmupath) throws Exception
	{
		String pLine = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(cmupath))); 
		try 
		{
			while((pLine = br.readLine())!= null) 
			{
				if(pLine.length() > word.length() && word.equalsIgnoreCase(pLine.substring(0, word.length())))
					break; 
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			pLine = null;
			e.printStackTrace();
		}
		finally
		{
			if(pLine == null)
				throw new Exception("No matched word found!");
			br.close();
			return pLine;
		}
	}
}

class Rhythm
{
	public int[] length;
	public int[] volume;
	public int[] note;
	public Rhythm(int n)
	{
		length = new int[n];
		volume = new int[n];
		note = new int[n];
		//for(int i = 0; i < n; i++)
			//note[i] = pitch;
		//for(int i = 0; i < n; i++)
			//note[i] = pitch;
	}
}