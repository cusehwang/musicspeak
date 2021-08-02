import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.TrayIcon.MessageType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimerTask;
import java.util.Vector;

import javax.sound.midi.Instrument;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MetaEventListener;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Soundbank;
import javax.sound.midi.Synthesizer;
import javax.sound.midi.Track;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.TargetDataLine;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.util.Timer;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;


public class UserInterface extends javax.swing.JApplet implements ChangeListener, ActionListener, MetaEventListener 
{

	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		/** Creates new form UserInterface */
	    //public UserInterface() {
		public void init(){
	    	/*
	    	String cmupath = System.getProperty("CMUPATH");
	    	String fwlpath = System.getProperty("FWLPATH");
	    	String recbpath = System.getProperty("RECBPATH");
	    	String playbpath = System.getProperty("PLAYBPATH");
	    	String stopbpath = System.getProperty("STOPBPATH");
	    	String savebpath = System.getProperty("SAVEBPATH");
	    	String hccllogopath = System.getProperty("HCCLLOGOPATH");
	    	String cuhklogopath = System.getProperty("CUHKLOGOPATH");
	    	String rhythmbpath = System.getProperty("RHYTHMBPATH");
	    	*/

	    	//cmupath = this.getClass().getResource(getParameter("DICTPATH"));
	    	//fwlpath = this.getClass().getResource(getParameter("FWLPATH"));
			cmupath = getParameter("DICTPATH");
			fwlpath = getParameter("FWLPATH");
	    	recbpath = this.getClass().getResource(getParameter("RECBPATH"));
	    	playbpath = this.getClass().getResource(getParameter("PLAYBPATH"));
	    	stopbpath = this.getClass().getResource(getParameter("STOPBPATH"));
	    	savebpath = this.getClass().getResource(getParameter("SAVEBPATH"));
	    	hccllogopath = this.getClass().getResource(getParameter("HCCLLOGOPATH"));
	    	cuhklogopath = this.getClass().getResource(getParameter("CUHKLOGOPATH"));
	    	rhythmbpath = this.getClass().getResource(getParameter("RHYTHMBPATH"));
	    	
			/*try{
				System.out.println(getParameter("RHYTHMBPATH"));
				System.out.println(rhythmbpath);
				}catch(NullPointerException e){
					System.out.println("caught");
				}finally{
					System.out.println("finally");
				}*/
	    	
	        initComponents();
                //addWindowListener(new WindowAdapter() {
                //public void windowClosing(WindowEvent e) {}
            //});
	    }
		
		public void start() {} 
		
		public void stop() {} 

		public void destroy() {}

	    /** This method is called from within the constructor to
	     * initialize the form.
	     * WARNING: Do NOT modify this code. The content of this method is
	     * always regenerated by the Form Editor.
	     */
	    //@SuppressWarnings("unchecked")
	    // <editor-fold defaultstate="collapsed" desc="Generated Code">
	    private void initComponents() {

	        jTabbedPane = new javax.swing.JTabbedPane();
	        jPanel1 = new javax.swing.JPanel();
	        jScrollPane1 = new javax.swing.JScrollPane();
	        jTextArea1 = new javax.swing.JTextArea();
	        jButton1 = new javax.swing.JButton();
	        jButton2 = new javax.swing.JButton();
	        jPanel2 = new javax.swing.JPanel();
	        /*
	        jMenuBar1 = new javax.swing.JMenuBar();
	        jMenu1 = new javax.swing.JMenu();
	        jSeparator3 = new javax.swing.JSeparator();
	        jMenu3 = new javax.swing.JMenu();
	        jMenuItem5 = new javax.swing.JMenuItem();
	        jSeparator4 = new javax.swing.JSeparator();
	        jMenuItem1 = new javax.swing.JMenuItem();
	        jMenu2 = new javax.swing.JMenu();
	        jMenuItem2 = new javax.swing.JMenuItem();
	        jSeparator1 = new javax.swing.JSeparator();
	        jMenuItem3 = new javax.swing.JMenuItem();
	        jSeparator2 = new javax.swing.JSeparator();
	        jMenuItem4 = new javax.swing.JMenuItem();
	        */
	        jInstrumentsPanel = new InstrumentsTable();
	        //pitch = 60;
	        psv = 100;
	        ssv = 80;
	        usv = 50;
	        inM = 300;
	        measure = 1000;

	        open();//Dara
	        
	        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

	        //jTextPane1.setColumns(50);
	        //jTextPane1.setRows(5);
	        //jTextArea1.setEditable(true);
	        jTextArea1.setText("Please input an English sentence here.");
            //jTextArea1.setLineWrap(true);
            jTextArea1.setFont(new Font("Times New Roman", Font.BOLD, 30));
            jTextArea1.setPreferredSize(new Dimension(600, 250));
            TitledBorder inputPBorder = new TitledBorder("Input Area");
            inputPBorder.setTitleFont(BTfont1);
	        jTextArea1.setBorder(inputPBorder);
	        jScrollPane1.setViewportView(jTextArea1);
	        jScrollPane1.setBorder(new EmptyBorder(30,100,50,100));
	        //jScrollPane1.setPreferredSize(new Dimension(600, 200));

	        jButton1.setText("Reset");
	        jButton1.setFont(Bfont);
	        jButton1.setPreferredSize(new Dimension(150, 50));
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton1ActionPerformed(evt);
	            }
	        });

	        jButton2.setText("Submit");
	        jButton2.setFont(Bfont);
	        jButton2.setPreferredSize(new Dimension(150, 50));
	        jButton2.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
							try {
								jButton2ActionPerformed(evt);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
	            }
	        });

	        //Tab 1
	        jPanel1Layout = new BorderLayout(10, 10);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1.add(jScrollPane1, BorderLayout.CENTER);
	        JPanel inputBP = new JPanel();
	        FlowLayout inputblayout = new FlowLayout();
	        inputblayout.setAlignment(FlowLayout.CENTER);
	        inputBP.setLayout(inputblayout);
	        inputBP.add(jButton1);
	        inputBP.add(jButton2);
	        jPanel1.add(inputBP, BorderLayout.SOUTH);

	        jTabbedPane.addTab("     Input Panel     ", jPanel1);
	        

	    	jPanel2Layout = new BorderLayout(5,5);
	    	jPanel2.setLayout(jPanel2Layout);
	    	jPanel2.add(jInstrumentsPanel, BorderLayout.SOUTH);
	        JPanel volumeP = new JPanel();
                TitledBorder tb1= new TitledBorder(new EtchedBorder());
                tb1.setTitle("Strength");
                tb1.setTitleFont(BTfont2);
                volumeP.setBorder(tb1);
                psS = createSlider("Pri Stress", volumeP, 100);
                ssS = createSlider("Sec Stress", volumeP, 80);
                usS = createSlider("Unstress", volumeP, 50);
                JPanel speedP = new JPanel();
                TitledBorder tb2 = new TitledBorder(new EtchedBorder());
                tb2.setTitle("Speed");
                tb2.setTitleFont(BTfont2);
                speedP.setBorder(tb2);
                inmS = createIncomSlider("Incmplt Bar", speedP, 300);
                measureS = createMeasureSlider("Bar", speedP, 1000);
                
                psS.setPreferredSize(new Dimension(150, 50));
                ssS.setPreferredSize(new Dimension(150, 50));
                usS.setPreferredSize(new Dimension(150, 50));
                inmS.setPreferredSize(new Dimension(180, 50));
                measureS.setPreferredSize(new Dimension(180, 50));
                
                //volumeP.setMinimumSize(new Dimension(460, 100));
                //speedP.setMinimumSize(new Dimension(340, 100));
                JPanel sliderP = new JPanel();
                sliderP.setLayout(new FlowLayout());
                sliderP.add(volumeP);
                sliderP.add(speedP);
                //sliderP.setPreferredSize(new Dimension(850,70));
                jPanel2.add(sliderP, BorderLayout.NORTH);
                
                JPanel toolP = new JPanel();
                toolP.setLayout(new BorderLayout(5, 5));
                //JPanel buttonP = new JPanel();
                JPanel pitchP = new JPanel();
                pS = createPitchSlider("Pitch", pitchP, 60);
                
                /*
                pS.setPreferredSize(new Dimension(100, 45));
                */
                pS.setPreferredSize(new Dimension(150, 50));
                
                //playB = createButton("Play", buttonP, false);
                //saveB = createButton("Save", buttonP, false);
                playB = new JButton(new ImageIcon(rhythmbpath));
                saveB = new JButton(new ImageIcon(savebpath));
                playB.setEnabled(false);
                saveB.setEnabled(false);
                playB.addActionListener(this);
                saveB.addActionListener(this);
                //buttonP.setLayout(new BorderLayout(5, 5));
                //buttonP.add(playB, BorderLayout.CENTER);
                //buttonP.add(saveB, BorderLayout.SOUTH);
                toolP.add(playB, BorderLayout.CENTER);
                toolP.add(saveB, BorderLayout.SOUTH);
                //toolP.add(pitchP, BorderLayout.NORTH);
                jPanel2.add(toolP, BorderLayout.EAST);
                sequencer.addMetaEventListener(this);
                
                //JPanel speechP = new JPanel();
                //speechP.setLayout(new BorderLayout());
                //JPanel speakP = new JPanel();
                //speakB = createButton("Speak", speakP, false);
                recordPanel recordP = new recordPanel(recbpath, playbpath, stopbpath, savebpath);
                //speechP.add(speakP, BorderLayout.CENTER);
                //speechP.add(recordP, BorderLayout.SOUTH);
                jPanel2.add(recordP, BorderLayout.WEST);
                JPanel textAreaP = new JPanel();
                textAreaP.setLayout(new BorderLayout(10, 10));
                TitledBorder outputPBorder = new TitledBorder(" Input Text ");
                outputPBorder.setTitleFont(BTfont1);
                textAreaP.setBorder(outputPBorder);
    	    	textP = new JPanel();
    	    	textP.setLayout(new FlowLayout());
    	    	textP.setBorder(new EmptyBorder(60, 10, 10, 10));
    	    	textAreaP.add(textP, BorderLayout.CENTER);
    	    	jPanel2.add(textAreaP, BorderLayout.CENTER);
	    	
	        jTabbedPane.addTab("     Result Panel     ", jPanel2);
	        
	        jTabbedPane.setFont(Tfont);
/*
	        jMenu1.setText("Control");
	        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseEntered(java.awt.event.MouseEvent evt) {
	                jMenu1MouseEntered(evt);
	            }
	        });
	        jMenu1.add(jSeparator3);

	        jMenu3.setText("History");

	        jMenuItem5.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
	        jMenuItem5.setText("<Empty>");
	        jMenuItem5.setEnabled(false);
	        jMenu3.add(jMenuItem5);

	        jMenu1.add(jMenu3);
	        jMenu1.add(jSeparator4);

	        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
	        jMenuItem1.setText("Exit");
	        jMenuItem1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
	        jMenu1.add(jMenuItem1);

	        jMenuBar1.add(jMenu1);

	        jMenu2.setText("Info");

	        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
	        jMenuItem2.setText("CMUDICT");
	        jMenu2.add(jMenuItem2);
	        jMenu2.add(jSeparator1);

	        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
	        jMenuItem3.setText("Project Report");
	        jMenu2.add(jMenuItem3);
	        jMenu2.add(jSeparator2);

	        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
	        jMenuItem4.setText("About...");
	        jMenu2.add(jMenuItem4);

	        jMenuBar1.add(jMenu2);

	        setJMenuBar(jMenuBar1);
*/
	        //setTitle("MusicSpeak");
	        
	        JLabel hccllogo = new JLabel(new ImageIcon(hccllogopath));
	        JLabel cuhklogo = new JLabel(new ImageIcon(cuhklogopath));
	        JPanel logoPanel = new JPanel();
	        FlowLayout logolayout = new FlowLayout();
	        logolayout.setAlignment(FlowLayout.RIGHT);
	        logoPanel.setLayout(logolayout);
	        logoPanel.add(hccllogo);
	        logoPanel.add(cuhklogo);
	        
	        Container mainContainer = getContentPane();
	        mainContainer.setLayout(new BorderLayout(20, 20));
	        mainContainer.add(jTabbedPane, BorderLayout.CENTER);
	        mainContainer.add(logoPanel, BorderLayout.NORTH);
	        
	        //Set the theme of the GUI
	        //String lnfName = "javax.swing.plaf.metal.MetalLookAndFeel"; 
	        //String lnfName = "com.sun.java.swing.plaf.motif.MotifLookAndFeel"; 
	        //String lnfName= "com.sun.java.swing.plaf.windows.WindowsLookAndFeel"; 
	        String lnfName = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";
	        //String lnfName = "com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel";
	        try {
				UIManager.setLookAndFeel(lnfName);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedLookAndFeelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        setPreferredSize(new Dimension(950, 720));
	        //pack();
	        
	    }// </editor-fold>


	    private JSlider createSlider(String name, JPanel p, int init) {
            JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 127, init);
            slider.addChangeListener(this);
            TitledBorder tb = new TitledBorder(new EtchedBorder());
            tb.setTitle(name + " : " + init);
            slider.setBorder(tb);
            tb.setTitleFont(Sliderfont);
            p.add(slider);
            p.add(Box.createHorizontalStrut(5));
            return slider;
        }	    
	    
	    private JSlider createPitchSlider(String name, JPanel p, int init) {
            JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 127, init);
            slider.addChangeListener(this);
            TitledBorder tb = new TitledBorder(new EtchedBorder());
            tb.setTitle(name + " : " + init);
            slider.setBorder(tb);
            tb.setTitleFont(PCfont);
            p.add(slider);
            p.add(Box.createHorizontalStrut(5));
            return slider;
        }	    
	    
	    private JSlider createIncomSlider(String name, JPanel p, int init) {
            JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 1000, init);
            slider.addChangeListener(this);
            TitledBorder tb = new TitledBorder(new EtchedBorder());
            tb.setTitle(name + " : " + init);
            slider.setBorder(tb);
            tb.setTitleFont(Sliderfont);
            p.add(slider);
            p.add(Box.createHorizontalStrut(5));
            return slider;
        }
	    
	    private JSlider createMeasureSlider(String name, JPanel p, int init) {
            JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 3000, init);
            slider.addChangeListener(this);
            TitledBorder tb = new TitledBorder(new EtchedBorder());
            tb.setTitle(name + " : " + init);
            tb.setTitleFont(Sliderfont);
            slider.setBorder(tb);
            p.add(slider);
            p.add(Box.createHorizontalStrut(5));
            return slider;
	    }
        public void stateChanged(ChangeEvent e) {
            JSlider slider = (JSlider) e.getSource();
            int value = slider.getValue();
            TitledBorder tb = (TitledBorder) slider.getBorder();
            String s = tb.getTitle();
            tb.setTitle(s.substring(0, s.indexOf(':') + 1) + s.valueOf(value));
            if (s.startsWith("Pri")) {
                psv = value;
            } else if (s.startsWith("Sec")) {
            	ssv = value;
            } else if (s.startsWith("Unstress")) {
                usv = value;
            } else if (s.startsWith("Pitch")) {
                pitch = value;
            }else if (s.startsWith("Incmplt")) {
            	inM = value;
            } else if (s.startsWith("Bar")) {
                measure = value;
            }
            slider.repaint();
        }
        
        //To recommendate the durations for (in)complete bars according to the number of the beats of each bar
        private void barDurationRecommendation(Sentence s)
        {
        	int count = 0, tempCount = 0, pos = 0;
        	int maxbarCount = 0, incbarCount = 0;
        	int[] measureCount;
        	for(int i = 0; i < s.template.length; i++)
        		if(s.template[i] == 1)
        			count++;
        	measureCount = new int[count + 1];
        	for(int i = 0; i < s.template.length; i++)
        	{
        		if(i % 2 == 0)
        			tempCount += s.template[i];
        		else if(i % 2 == 1)
        		{
        			if(s.template[i] == 2)
        				tempCount++;
        			else //s.template[i] == 1 which means it is the starting beat of a bar
        			{
        				measureCount[pos] = tempCount;
        				tempCount = 1;
        				if(pos == 0)
        					incbarCount = measureCount[0];
        				else if(pos == 1)
        					maxbarCount = measureCount[1];
        				else if(pos >= 2 && maxbarCount < measureCount[pos])
        					maxbarCount = measureCount[pos];
        				pos++;
        			}
        		}        			
        	}
        	//for the last bar
        	measureCount[pos] = tempCount;
        	/*
        	*/
			tempCount = 1;
			if(pos == 0)
				incbarCount = measureCount[0];
			else if(pos == 1)
				maxbarCount = measureCount[1];
			else if(pos >= 2 && maxbarCount < measureCount[pos])
				maxbarCount = measureCount[pos];
			pos++;
        	
			//bar duration recommendation
			//for incomplete bar
        	inM = 200 * incbarCount; //average duration of a syllable is 0.2 second
        	/*
			if(incbarCount <= 1)
				inM = 250;
			else if(incbarCount == 2)
				inM = 400;
			else if(incbarCount == 3)
				inM = 650;
			else
				inM = 800;
			*/
        	
            TitledBorder tb1 = (TitledBorder) inmS.getBorder();
            String st1 = tb1.getTitle();
            tb1.setTitle(st1.substring(0, st1.indexOf(':') + 1) + st1.valueOf(inM));
            inmS.setValue(inM);
	    	
			//for complete bar
            measure = 200 * maxbarCount;
            /*
			if(maxbarCount <= 1)
				measure = 400;
			else if(maxbarCount == 2)
				measure = 600;
			else if(maxbarCount == 3)
				measure = 850;
			else
				measure = 1000;
			*/
            TitledBorder tb2 = (TitledBorder) measureS.getBorder();
            String st2 = tb2.getTitle();
            tb2.setTitle(st2.substring(0, st2.indexOf(':') + 1) + st2.valueOf(measure));
	    	measureS.setValue(measure);
        }
        
	    /*public JButton createButton(String name, JPanel p, boolean state) {
            JButton b = new JButton(name);
            b.setFont(new Font("serif", Font.PLAIN, 13));
            b.setEnabled(state);
            b.addActionListener(this);
            p.add(b);
            return b;
        }*/
	    
        public void actionPerformed(ActionEvent e) 
        {
            JButton button = (JButton) e.getSource();
            if (button.equals(playB)) {
                //if (playB.getText().startsWith("Play")) {
                	//if(ptThread != null)
                	//	ptThread
                	ptThread = new Thread()//Thread for text playing
                	{
                		private String word;
                		private JLabel l = null;
                		private int wordtime, wordnum, i, sc = 0;
                		public void run()
                		{
                			l = (JLabel) wordLabelBox.get(wordnum);      		
                        	word = l.getText();
                        	l.setFont(Sfont);
                        	l.setText(changeWD(s.word[wordnum]));
                        	for(wordnum = 0; wordnum < s.wcount;)
                        	{
                        		for(wordtime = 0, i = 0; i < s.word[wordnum].syllables.length; i++, sc++)
                        			wordtime += s.rhythm.length[sc]; 
                				  //System.out.println("test1!: " + wordtime);
                        		try
                        		{
                        	        sleep(wordtime);
                        	    }
                        		catch(Exception ex)
                        		{
                        			ex.printStackTrace();
                        		}
                        		JLabel l = (JLabel) wordLabelBox.get(wordnum);
                        		l.setText(word);
                        		l.setFont(Ofont);
                        		wordnum++;
                        		if(wordnum == wordLabelBox.size())
                        			return;
                        		l = (JLabel) wordLabelBox.get(wordnum);
                        		word = l.getText();
                        		l.setText(changeWD(s.word[wordnum]));
                        		l.setFont(Sfont);
                        	}
                        }
                	};
                    try {
                    	s.updateSetting(pspitch, sspitch, uspitch, psv, ssv, usv, inM, measure);
                    	createSequence();
                        sequencer.open();
                        sequencer.setSequence(sequence);
                    } catch (Exception ex) { ex.printStackTrace(); }
                    //textP.setEnabled(false);
                    sequencer.start();
                    ptThread.start();
                    //textP.setEnabled(true);
                    //playText();
                    //playB.setText("Stop");
                    //playB.setEnabled(false);
                    /*} else {
                    sequencer.stop();
                    playB.setText("Play");
                } */
            } else if (button.equals(saveB)) {
                try {
                    //File file = new File("C:\\");//(System.getProperty("user.dir"));
                    JFileChooser fc = new JFileChooser("C:\\");
                    FileNameExtensionFilter midifilter = new FileNameExtensionFilter("MIDI Audio File", "midi","MIDI");//设置默认文件选项
                    fc.addChoosableFileFilter(midifilter);
                    fc.setFileSelectionMode(JFileChooser.FILES_ONLY );

                    /*fc.setFileFilter(new javax.swing.filechooser.FileFilter() {
                        public boolean accept(File f) {
                            if (f.isDirectory()) {
                                return true;
                            }
                            return false;
                        }
                        public String getDescription() {
                            return "Save as .mid file.";
                        }
                    });*/
                    if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    	File targetMidiFile;
                    	String filepath = fc.getSelectedFile().getAbsolutePath();
                    	if(filepath.endsWith(".midi"))
                    	{
                    		targetMidiFile = fc.getSelectedFile();
                    	}
                    	else
                    	{
                    		targetMidiFile = new File(filepath + ".midi");
                    	}
                        saveMidiFile(targetMidiFile);
                    }
                } catch (SecurityException ex) {
                    ex.printStackTrace();
                } catch (Exception ex) { 
                    ex.printStackTrace();
                }
            }
            /*else if(button.equals(speakB)){
            	try 
            	{
            		javax.speech.synthesis.Synthesizer synth = Central.createSynthesizer(null);
            		synth.allocate();
            		synth.resume();
            		synth.speakPlainText(s.sentence,null);
            		synth.waitEngineState(javax.speech.synthesis.Synthesizer.QUEUE_EMPTY);
            		synth.deallocate();
            	}catch (Exception evt) 
            	{
            		evt.printStackTrace();
            	}
            }*/
        }

        public void meta(MetaMessage message) {
            if (message.getType() == 47) {  // 47 is end of track
                //playB.setText("Play");
            	playB.setEnabled(true);
            }
        }

        public void saveMidiFile(File file) {
            try {
                int[] fileTypes = MidiSystem.getMidiFileTypes(sequence);
                if (fileTypes.length == 0) {
                    System.out.println("Can't save sequence");
                } else {
                    if (MidiSystem.write(sequence, fileTypes[0], file) == -1) {
                        throw new IOException("Problems writing to file");
                    } 
                }
            } catch (SecurityException ex) { 
                //JavaSound.showInfoDialog();
            } catch (Exception ex) { 
                ex.printStackTrace(); 
            }
        }
        
        /*class MidiFileFilter extends FileFilter implements FilenameFilter
        {     
        		public static final String MIDI_EXTENSION = ".midi";     
        		public static final String MIDI_DESCRIPTION = "MIDI Audio File";     
        		public boolean accept(File dir, String name)    
        		{         
        			try        
        			{             
        				if (name != null)             
        				{                 
        					return name.endsWith(MIDI_EXTENSION);             
        				}        
        			}         
        			catch (Exception e)         
        			{         
        		}         
        			return false;     
        		}     
        		public boolean accept(File file)    
        		{         
        			try        
        			{             
        				//check if the file is not nule and if the file is a directory             
        				if (file != null && file.isDirectory())             
        				{                 
        					return true;             
        				}             
        				//check if the file extension is ".pdf"             
        				if (file != null && file.getCanonicalPath() != null)             
        				{                 
        					return file.getCanonicalPath().endsWith(MIDI_EXTENSION);             
        				}         
        			}         
        			catch (Exception e)         
        			{         
        			}         
        			return false;     
        		}       
        		public String getDescription()
        		{         
        			return MIDI_DESCRIPTION;     
        		} 
        } */

        
	    private void jMenu1MouseEntered(java.awt.event.MouseEvent evt) {
	        // TODO add your handling code here:
	    }

	    //set button
	    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
	    	jTextArea1.setEnabled(true);
	    	jButton2.setEnabled(true);
	    	jTextArea1.setText("Please input and English sentence here.");
	    }
	    
	    private String text;
	    //submit button
	    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
	    	textP.removeAll();
	    	text = jTextArea1.getText();
	    	//playB.setEnabled(true);
	    	//saveB.setEnabled(true);
	    	//String cmupath, fwlpath;
	    	//cmupath = System.getProperty("CMUPATH");
	    	//fwlpath = System.getProperty("FWLPATH");
	    	//cmupath = "D:\\JavaMission\\SEG5120\\src\\cmudict.0.7a";
	    	//fwlpath = "D:\\JavaMission\\SEG5120\\src\\FunctionWords.txt";
	    	try
	    	{
		    	s = new Sentence(cmupath, fwlpath, text, pspitch, sspitch, uspitch, psv, ssv, usv, inM, measure);
        	createSequence();
        	playB.setEnabled(true);
        	saveB.setEnabled(true);
        	//speakB.setEnabled(true);
        	wordLabelBox = new Vector<JLabel>();
	    	for(int i = 0; i < s.wcount; i++)
	    	{
	    		JLabel newlabel = new JLabel(s.word[i].word);
	    		newlabel.setFont(Ofont);
	    		newlabel.setToolTipText(s.word[i].pron);
	    		newlabel.addMouseListener(new MouseAdp());
	    		wordLabelBox.add(newlabel);
	    		textP.add(newlabel);
	    	}
	    	barDurationRecommendation(s);
	    	jTextArea1.setEnabled(false);
	    	jButton2.setEnabled(false);
	    	jTabbedPane.setSelectedIndex(1);	    	
	    	}
	    	catch(Exception e)
	    	{
	    		String[] tempStrArr1 = null;
	    		String[] tempStrArr2 = null;
	    		String newSentence = "";
	    		if(e.getMessage().startsWith("The word"))
	    		{
	    			//get the wrong word from the Exception message
	    			tempStrArr1 = e.getMessage().split(" ");
	    			String wrongWord = tempStrArr1[2];
	    			//System.out.println(wrongWord);
	    			//identify the wrong word from the user input
	    			tempStrArr2 = text.split(" ");
	    			for(int i = 0; i < tempStrArr2.length; i++)
	    			{
	    				if(tempStrArr2[i].startsWith(wrongWord) || tempStrArr2[i].endsWith(wrongWord))
	    				{
	    					tempStrArr2[i] = "<font color=red><b>" + tempStrArr2[i] + "</b></font>";
	    				}
	    				newSentence = newSentence + tempStrArr2[i] + " ";
	    			}
	    			//jTextArea1.setText(newSentence + "\nThe word in red could not be found in the dictionary.");

	    			//jTextArea1.setContentType("text/html");
	    			//jTextArea1.setText("<html>" + newSentence + "</html>");
	    			
	    			//Pop out a message to identify the possible spelling error
	    			JOptionPane jo;
	    			jo = new JOptionPane();
	    			JLabel jl = new JLabel();
	    			jl.setFont(new Font("serif", Font.PLAIN, 16));
	    			jl.setText("<html>" + newSentence + "</html>");
	    			JOptionPane.showMessageDialog(null, jl, "Possible Spelling Error", 0);

	    		}
	    	}
	    }

	    /**
	    * @param args the command line arguments
	    */
	    /*public static void main(String args[]) {
	        java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	            	UserInterface ui = new UserInterface();
	                ui.setVisible(true);
	            }
	        });
	    }*/

	    // Variables declaration - do not modify
	    private javax.swing.JButton jButton1;
	    private javax.swing.JButton jButton2;
	    private javax.swing.JMenu jMenu1;
	    private javax.swing.JMenu jMenu2;
	    private javax.swing.JMenu jMenu3;
	    private javax.swing.JMenuBar jMenuBar1;
	    private javax.swing.JMenuItem jMenuItem1;
	    private javax.swing.JMenuItem jMenuItem2;
	    private javax.swing.JMenuItem jMenuItem3;
	    private javax.swing.JMenuItem jMenuItem4;
	    private javax.swing.JMenuItem jMenuItem5;
	    private javax.swing.JPanel jPanel1;
	    private javax.swing.JPanel jPanel2;
	    private javax.swing.JPanel textP;
	    private javax.swing.JScrollPane jScrollPane1;
	    private javax.swing.JSeparator jSeparator1;
	    private javax.swing.JSeparator jSeparator2;
	    private javax.swing.JSeparator jSeparator3;
	    private javax.swing.JSeparator jSeparator4;
	    private javax.swing.JTabbedPane jTabbedPane;
	    private javax.swing.JTextArea jTextArea1;
        private java.awt.BorderLayout jPanel1Layout;
        private java.awt.BorderLayout jPanel2Layout;
	    private InstrumentsTable jInstrumentsPanel;
	    private javax.swing.JButton saveB;
	    private javax.swing.JButton playB;
        private javax.swing.JButton speakB;
        private javax.swing.JSlider psS;
	    private javax.swing.JSlider ssS;
	    private javax.swing.JSlider usS;
	    private javax.swing.JSlider pS;
	    private javax.swing.JSlider inmS;
	    private javax.swing.JSlider measureS;
	    private final Font Ofont = new Font("Times New Roman", Font.BOLD, 30); //for words which is at normal state
	    private final Font Sfont = new Font("Times New Roman", Font.BOLD, 34);  //for currently spoken words
	    private final Font Tfont = new Font("sansserif", Font.BOLD + Font.ITALIC, 20);  //for tag title
	    private final Font Bfont = new Font("sansserif", Font.BOLD, 24);  //for buttons
	    private final Font BTfont1 = new Font("monospaced", Font.BOLD, 18);  //for input/output panel border title
	    private final Font BTfont2 = new Font("monospaced", Font.BOLD, 15);  //for slider panel border title
	    private final Font PCfont = new Font("monospaced", Font.BOLD, 16);  //for other panel components
	    private final Font Sliderfont = new Font("monospaced", Font.BOLD, 14);  //for slider panel components
	    private final Font ITHfont = new Font("monospaced", Font.BOLD, 14);  //for instrument table header
	    private final Font ITfont = new Font("serif", Font.PLAIN, 14);  //for instrument table
	
	    private final int PROGRAM = 192;
	    private final int NOTEON = 144;
	    private final int NOTEOFF = 128;
        private final String recordStr = "<html><font face=\"wingdings\" color=red>&#108;</font></html>";
        private final String rstopStr = "<html><font face=\"wingdings\">&#110;</font></html>";
        private final String rplayStr = "<html><font face=\"wingdings 3\">&#132;</font></html>";
        private final String rsaveStr = "<html><font face=\"wingdings\">&#60;</font></html>";
	    private Sequencer sequencer;
	    private Sequence sequence;
	    private Synthesizer synthesizer;
	    private Instrument instruments[];
	    private ChannelData channels[];
	    private ChannelData cc;
	    private int psv, ssv, usv, pitch, inM, measure;
		private final int pspitch = 70;
		private final int sspitch = 60;
		private final int uspitch = 50;
	    private Vector<JLabel> wordLabelBox;
	    private JTable table;
	    private Track track;
	    private Sentence s;
	    String cmupath = null, fwlpath = null;
		private URL recbpath = null, playbpath = null, stopbpath = null;
	    private URL savebpath = null, hccllogopath = null, cuhklogopath = null, rhythmbpath = null;
	    private Thread ptThread = null;
	    
	    // End of variables declaration
        
        /**
         * Stores MidiChannel information.
         */
        class ChannelData {
            MidiChannel channel;
            boolean solo, mono, mute, sustain;
            int velocity, pressure, bend, reverb;
            int row, col, num;

            public ChannelData(MidiChannel channel, int num) {
                this.channel = channel;
                this.num = num;
                //velocity = pressure = bend = reverb = 64;
            }
            public void setComponentStates() {
                table.setRowSelectionInterval(row, row);
                table.setColumnSelectionInterval(col, col);
                //sustCB.setSelected(sustain);
                /*JSlider slider[] = { veloS, presS, bendS, revbS };
                int v[] = { velocity, pressure, bend, reverb };
                for (int i = 0; i < slider.length; i++) {
                    TitledBorder tb = (TitledBorder) slider[i].getBorder();
                    String s = tb.getTitle();
                    tb.setTitle(s.substring(0, s.indexOf('=')+1)+s.valueOf(v));
                    slider[i].repaint();
                }*/
            }
        } // End class ChannelData
        
        /**
         * Table for 128 general MIDI melody instuments.
         */
        class InstrumentsTable extends JPanel {
            private String names[] = { 
               "Piano", "Chromatic Perc.", "Organ", "Guitar", 
               "Bass", "Strings", "Ensemble", "Brass", 
               "Reed", "Pipe", "Synth Lead", "Synth Pad",
               "Synth Effects", "Ethnic", "Percussive", "Sound Effects" };
            private int nRows = 8;
            private int nCols = names.length; // just show 128 instruments
            public InstrumentsTable() {
                setLayout(new BorderLayout());
                TableModel dataModel = new AbstractTableModel() {
                    public int getColumnCount() { return nCols; }
                    public int getRowCount() { return nRows;}
                    public Object getValueAt(int r, int c) { 
                        if (instruments != null) {
                            return instruments[c*nRows+r].getName();
                        } else {
                            return Integer.toString(c*nRows+r);
                        }
                    }
                    public String getColumnName(int c) { 
                        return names[c];
                    }
                    public Class getColumnClass(int c) {
                        return getValueAt(0, c).getClass();
                    }
                    public boolean isCellEditable(int r, int c) {return false;}
                    public void setValueAt(Object obj, int r, int c) {}
                };

                table = new JTable(dataModel);
                
                table.getTableHeader().setFont(ITHfont);
                table.setFont(ITfont);
                
                table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                // Listener for row changes
                ListSelectionModel lsm = table.getSelectionModel();
                lsm.addListSelectionListener(new ListSelectionListener() {
                    public void valueChanged(ListSelectionEvent e) {
                        ListSelectionModel sm = (ListSelectionModel) e.getSource();
                        if (!sm.isSelectionEmpty()) {
                            cc.row = sm.getMinSelectionIndex();
                        }
                        programChange(cc.col*nRows+cc.row);
                    }
                });
                // Listener for column changes
                lsm = table.getColumnModel().getSelectionModel();
                lsm.addListSelectionListener(new ListSelectionListener() {
                    public void valueChanged(ListSelectionEvent e) {
                        ListSelectionModel sm = (ListSelectionModel) e.getSource();
                        if (!sm.isSelectionEmpty()) {
                            cc.col = sm.getMinSelectionIndex();
                        }
                        programChange(cc.col*nRows+cc.row);
                    }
                });
                table.setPreferredScrollableViewportSize(new Dimension(nCols*120, 200));
                table.setCellSelectionEnabled(true);
                table.setColumnSelectionAllowed(true);
                for (int i = 0; i < names.length; i++) {
                    TableColumn column = table.getColumn(names[i]);
                    column.setPreferredWidth(120);
                }
                table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
            
                JScrollPane sp = new JScrollPane(table);
                sp.setVerticalScrollBarPolicy(sp.VERTICAL_SCROLLBAR_NEVER);
                sp.setHorizontalScrollBarPolicy(sp.HORIZONTAL_SCROLLBAR_ALWAYS);
                sp.doLayout();
                JScrollBar jscrollBar = sp.getVerticalScrollBar();
                if (jscrollBar != null)
                    jscrollBar.setValue(jscrollBar.getMaximum());
                add(sp);
            }
            public Dimension getPreferredSize() {
                return new Dimension(800,170);
            }
            public Dimension getMaximumSize() {
                return new Dimension(800,170);
            }
            private void programChange(int program) {
                if (instruments != null) {
                    synthesizer.loadInstrument(instruments[program]);
                }
                cc.channel.programChange(program);
            }
        }
        
        public String changeWD(Word w)
        {
        	if(w.stressed)
        		return "<html><font color=red>" + w.word + "</font></html>";
        	else
        		return "<html><font color=#99CC32>" + w.word + "</font></html>";
        }//#99CC32黄绿 yellow green
        
       /*public void playText()
        {
        	JLabel l = null;
        	int wordtime = 0;
        	int sc = 0;      		
    		l = (JLabel) wordLabelBox.get(timerC);
        	timerW = l.getText();
        	l.setFont(Sfont);
        	l.setText(changeWD(s.word[timerC]));  
        	for(timerC = 0; timerC < s.wcount;)
        	{
        		for(int i = 0; i < s.word[timerC].syllables.length; i++, sc++)
        			wordtime += s.rhythm.length[sc]; 
				  //System.out.println("test1!: " + wordtime);
        		new Timer().schedule(new TimerTask(){
        			  public void run() {
        				  JLabel l = (JLabel) wordLabelBox.get(timerC);
        				  l.setFont(Ofont);
        				  l.setText(timerW);
        				  timerC++;
        				  if(timerC == wordLabelBox.size())
        					  return;
        				  l = (JLabel) wordLabelBox.get(timerC);
        				  timerW = l.getText();
        				  l.setFont(Sfont);
        				  l.setText(changeWD(s.word[timerC])); 
        			}}, wordtime);
        	}
        }*/
        
        public void playText()
        {
        	Thread ptThread = new Thread()
        	{
        		private String word;
        		private JLabel l = null;
        		private int wordtime, wordnum, i, sc = 0;
        		public void run()
        		{
        			l = (JLabel) wordLabelBox.get(wordnum);      		
                	word = l.getText();
                	l.setFont(Sfont);
                	l.setText(changeWD(s.word[wordnum]));
                	for(wordnum = 0; wordnum < s.wcount;)
                	{
                		for(wordtime = 0, i = 0; i < s.word[wordnum].syllables.length; i++, sc++)
                			wordtime += s.rhythm.length[sc]; 
        				  //System.out.println("test1!: " + wordtime);
                		try
                		{
                	        sleep(wordtime);
                	    }
                		catch(Exception ex)
                		{
                			ex.printStackTrace();
                		}
                		JLabel l = (JLabel) wordLabelBox.get(wordnum);
                		l.setText(word);
                		l.setFont(Ofont);
                		wordnum++;
                		if(wordnum == wordLabelBox.size())
                			return;
                		l = (JLabel) wordLabelBox.get(wordnum);
                		word = l.getText();
                		l.setText(changeWD(s.word[wordnum]));
                		l.setFont(Sfont);
                	}
                }
        	};
        	ptThread.start();
        }
        
        class MouseAdp implements MouseListener{        
        	public MouseAdp(){}
        	JLabel l = null;
        	String word;
        	
                    public void mouseEntered(MouseEvent e) 
                    { 
                    	if(ptThread != null && ptThread.isAlive())
                    		return;
                    	int num = 0;
                    	l = (JLabel) e.getSource();
                    	for(int i = 0; i < s.wcount; i++)
                    		if(l.getText() == s.word[i].word)
                    		{
                    			num = i;
                    			break;
                    		}
                    	word = l.getText();
                    	l.setFont(Sfont);
                    	l.setText(changeWD(s.word[num]));
                    }

                    public void mouseExited(MouseEvent e) 
                    {
                    	if(ptThread != null && ptThread.isAlive())
                    		return;
                    	if(l != null)
                    	{
                        	l.setFont(Ofont);
                        	l.setText(word);
                    	}
                    }
                    
                    public void mouseClicked(MouseEvent e) 
                    {
                    	/*try 
                    	{
                    		if(l == null)
                    			return;
                    		javax.speech.synthesis.Synthesizer synth = Central.createSynthesizer(null);
                    		synth.allocate();
                    		synth.resume();
                    			
                    		synth.speakPlainText(l.getText(),null);
                    		
                    		synth.waitEngineState(javax.speech.synthesis.Synthesizer.QUEUE_EMPTY);
                    		synth.deallocate();
                    			
                    	} catch (Exception evt) {
                    		evt.printStackTrace();
                    	}*/
                    }
                    
                    public void mouseMoved(MouseEvent e) { }
                    public void mousePressed(MouseEvent e) { }
                    public void mouseReleased(MouseEvent e) { }
        }// End class textP
        
        public void createTrack() 
        {
            ShortMessage message;
            MidiEvent event;
            long tick;
            try {
            	message = new ShortMessage();
				message.setMessage(PROGRAM + cc.num, cc.col * 8 + cc.row, 0);
    			event = new MidiEvent(message, 0);
    			track.add(event);
			} catch (InvalidMidiDataException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int time = 0;
        	for(int i = 0; i < s.rhythm.length.length; i++)
        	{
        		try
        		{
        			tick = time * sequence.getResolution() / 500;
                	message = new ShortMessage();
        			message.setMessage(NOTEON + cc.num, s.rhythm.note[i], s.rhythm.volume[i]);
        			event = new MidiEvent(message, tick);
        			track.add(event);
        			time = time + s.rhythm.length[i];
        			tick = time * sequence.getResolution() / 500;
                	message = new ShortMessage();
        			message.setMessage(NOTEOFF + cc.num, s.rhythm.note[i], s.rhythm.volume[i]);
        			event = new MidiEvent(message, tick);
        			track.add(event);
        		}
        		catch (Exception ex) { ex.printStackTrace(); }
        	}
        }

        public void createSequence() 
        {
            try {
				sequence = new Sequence(Sequence.PPQ, 10);
			} catch (InvalidMidiDataException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			track = sequence.createTrack();
			createTrack();
        }
        
        public void open() {
            try {
                if (synthesizer == null) {
                    if ((synthesizer = MidiSystem.getSynthesizer()) == null) {
                        System.out.println("getSynthesizer() failed!");
                        return;
                    }
                } 
                synthesizer.open();
                sequencer = MidiSystem.getSequencer();
            } catch (Exception ex) { ex.printStackTrace(); return; }
            Soundbank sb = synthesizer.getDefaultSoundbank();
            if (sb != null) {
                instruments = synthesizer.getDefaultSoundbank().getInstruments();
                synthesizer.loadInstrument(instruments[0]);
            }
            MidiChannel midiChannels[] = synthesizer.getChannels();
            channels = new ChannelData[midiChannels.length];
            for (int i = 0; i < channels.length; i++) {
                channels[i] = new ChannelData(midiChannels[i], i);
            }
            /*cc = channels[0];
            ListSelectionModel lsm = table.getSelectionModel();
            lsm.setSelectionInterval(0,0);
            lsm = table.getColumnModel().getSelectionModel();
            lsm.setSelectionInterval(0,0);*/
            channels[0] = new ChannelData(midiChannels[0], 0);
            cc = channels[0];
            cc.row = 6;
            cc.col = 14;
        }
        
        class recordPanel extends JPanel {

            boolean stopCapture = false;       //控制录音标志

            AudioFormat audioFormat;           //录音格式

            //读取数据：从TargetDataLine写入ByteArrayOutputStream录音

            TargetDataLine targetDataLine;

            //播放数据：从AudioInputStream写入SourceDataLine播放

            AudioInputStream audioInputStream, tempais;
            
            final int bufSize = 16384;

            Capture capture = new Capture();
            
            ByteArrayOutputStream out;

            Playback playback = new Playback();

            JTextField textField;

            String errStr;

            double duration, seconds;

            File file;
            
    	    JButton recordB;
    	    JButton rplayB;
    	    JButton rsaveB;
    	    Boolean isRecording = false;
    	    Icon recbI;
    	    Icon playbI;
    	    Icon stopbI;
    	    Icon savebI;
    	    
            public recordPanel(URL recbpath, URL playbpath, URL stopbpath, URL savebpath) {
            	
                setLayout(new BorderLayout(5, 5));
                
        	    recbI = new ImageIcon(recbpath);
        	    playbI = new ImageIcon(playbpath);
        	    stopbI = new ImageIcon(stopbpath);
        	    savebI = new ImageIcon(savebpath);

                //创建按钮
        	    recordB = new JButton(recbI);
        	    //recordB.setPreferredSize(new Dimension(35, 35));//.setSize(25, 25);
        	    recordB.setSize(35, 35);
        	    recordB.setToolTipText("Record");
        	    rplayB = new JButton(playbI);
        	    rplayB.setEnabled(false);
        	    //rplayB.setPreferredSize(new Dimension(35, 35));
        	    rplayB.setSize(new Dimension(35, 35));
        	    rplayB.setToolTipText("Play Back the record");
        	    rsaveB = new JButton(savebI);
        	    rsaveB.setEnabled(false);
        	    //rsaveB.setPreferredSize(new Dimension(35, 35));
        	    rsaveB.setSize(new Dimension(35, 35));
        	    rsaveB.setToolTipText("Save the record");
        	    //JLabel tl = new JLabel();
        	    //String t = "<html><font face=\"wingdings\" color=red>" + "&#108;" + "</font></html>";
        	    //tl.setText(t);
        	    //add(tl);
        	    add(recordB, BorderLayout.NORTH);
        	    add(rplayB, BorderLayout.CENTER);
        	    add(rsaveB, BorderLayout.SOUTH);


                //注册录音事件

        	    recordB.addActionListener(new ActionListener() {
        	    	  
                    public void actionPerformed(ActionEvent e) 
                    {
                    	if(isRecording == false)
                    	{
                    		//recordB.setText("SR");
                    		recordB.setIcon(stopbI);
                    		recordB.setToolTipText("Stop recording");
                    		rplayB.setEnabled(false);
                    		rsaveB.setEnabled(false);
                    		capture.start();
                    		isRecording = true;
                    	}
                    	else if(isRecording == true)
                    	{
                    		//recordB.setText("<html><font color=red>Rec</font></html>");
                    		recordB.setIcon(recbI);
                    		recordB.setToolTipText("Record");
                    		rplayB.setEnabled(true);
                    		rsaveB.setEnabled(true);
                    		capture.stop();
                    		isRecording = false;
                    	}
                    }
                    });
        	    
                //注册播放事件

        	    rplayB.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {

                    	if(rplayB.getIcon() == playbI)
                    	{
                    		playback.start();
                    		recordB.setEnabled(false);
                    		rplayB.setIcon(stopbI);
                    		rplayB.setToolTipText("Stop playing the record");
                    	}
                    	else
                    	{
                    		playback.stop();                 
                    		rplayB.setIcon(playbI);
                    		rplayB.setToolTipText("Play Back the record");
                    		recordB.setEnabled(true);   		
                    	}

                    }

                });

                //注册保存事件

                rsaveB.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {

                        //保存录音

                        save();

                    }

                });

                //注册窗体关闭事件

                /*addWindowListener(new WindowAdapter() {

                    public void windowClosing(WindowEvent e) {

                        System.exit(0);

                    }

                });*/

            }
            
            public void open() {
            }

            public void close() {
              if (playback.thread != null) {
                rplayB.doClick(0);
              }
              if (capture.thread != null) {
                recordB.doClick(0);
              }
            }
            
            public AudioFormat getAudioFormat()
            {
            	AudioFormat.Encoding encoding = AudioFormat.Encoding.PCM_SIGNED;
    	        float rate = 22050.0f; //16000.0f;
    	        int channels = 1;
    	        int frameSize = 4;
    	        int sampleSize = 16;
    	        boolean bigEndian = true;

    	        AudioFormat format = new AudioFormat(encoding, rate, sampleSize, channels, (sampleSize / 8)
    	            * channels, rate, bigEndian);
    	        
    	        return format;
            }

    	    /**
    	     * Reads data from the input channel and writes to the output stream
    	     */
    	    class Capture implements Runnable {

    	      TargetDataLine line;

    	      Thread thread;

    	      public void start() {
    	        errStr = null;
    	        thread = new Thread(this);
    	        thread.setName("Capture");
    	        thread.start();
    	      }

    	      public void stop() {
    	        thread = null;
    	      }

    	      private void shutDown(String message) {
    	        if ((errStr = message) != null && thread != null) {
    	          thread = null;
    	          rplayB.setEnabled(true);
    	          recordB.setIcon(recbI);
    	          System.err.println(errStr);
    	        }
    	      }

    	      public void run() {

    	        duration = 0;
    	        audioInputStream = null;

    	        // define the required attributes for our line,
    	        // and make sure a compatible line is supported.

    	        /*
    	         * AudioFormat.Encoding encoding = AudioFormat.Encoding.PCM_SIGNED;
    	        
    	        float rate = 16000.0f;
    	        int channels = 2;
    	        int frameSize = 4;
    	        int sampleSize = 16;
    	        boolean bigEndian = true;

    	        AudioFormat format = new AudioFormat(encoding, rate, sampleSize, channels, (sampleSize / 8)
    	            * channels, rate, bigEndian);
				*/
    	        
    	        AudioFormat format = getAudioFormat();
    	        
    	        DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);

    	        if (!AudioSystem.isLineSupported(info)) {
    	          shutDown("Line matching " + info + " not supported.");
    	          return;
    	        }

    	        // get and open the target data line for capture.

    	        try {
    	          line = (TargetDataLine) AudioSystem.getLine(info);
    	          line.open(format, line.getBufferSize());
    	        } catch (LineUnavailableException ex) {
    	          shutDown("Unable to open the line: " + ex);
    	          return;
    	        } catch (SecurityException ex) {
    	          shutDown(ex.toString());
    	          //JavaSound.showInfoDialog();
    	          return;
    	        } catch (Exception ex) {
    	          shutDown(ex.toString());
    	          return;
    	        }

    	        // play back the captured audio data
    	        //ByteArrayOutputStream 
    	        out = new ByteArrayOutputStream();
    	        int frameSizeInBytes = format.getFrameSize();
    	        int bufferLengthInFrames = line.getBufferSize() / 8;
    	        int bufferLengthInBytes = bufferLengthInFrames * frameSizeInBytes;
    	        byte[] data = new byte[bufferLengthInBytes];
    	        int numBytesRead;

    	        line.start();

    	        while (thread != null) {
    	          if ((numBytesRead = line.read(data, 0, bufferLengthInBytes)) == -1) {
    	            break;
    	          }
    	          out.write(data, 0, numBytesRead);
    	        }

    	        // we reached the end of the stream.
    	        // stop and close the line.
    	        line.stop();
    	        line.close();
    	        line = null;

    	        // stop and close the output stream
    	        try {
    	          out.flush();
    	          out.close();
    	        } catch (IOException ex) {
    	          ex.printStackTrace();
    	        }

    	        // load bytes into the audio input stream for playback

    	        //byte audioBytes[] = out.toByteArray();
    	        byte audioBytes[] = out.toByteArray();
    	        ByteArrayInputStream bais = new ByteArrayInputStream(audioBytes);
    	        audioInputStream = new AudioInputStream(bais, format, audioBytes.length / frameSizeInBytes);

    	        long milliseconds = (long) ((audioInputStream.getFrameLength() * 1000) / format
    	            .getFrameRate());
    	        duration = milliseconds / 1000.0;

    	        try {
    	          audioInputStream.reset();
    	        } catch (Exception ex) {
    	          ex.printStackTrace();
    	          return;
    	        }

    	      }
    	    } // End class Capture

    	    /**
    	     * Write data to the OutputChannel.
    	     */
    	    public class Playback implements Runnable {

    	      SourceDataLine line;

    	      Thread thread;

    	      public void start() {
    	        errStr = null;
    	        thread = new Thread(this);
    	        thread.setName("Playback");
    	        thread.start();
    	      }

    	      public void stop() {
    	        thread = null;
    	      }

    	      private void shutDown(String message) {
    	        if ((errStr = message) != null) {
    	          System.err.println(errStr);
    	        }
    	        if (thread != null) {
    	          thread = null;
    	          recordB.setEnabled(true);
    	          rplayB.setIcon(playbI);
    	        }
    	      }

    	      public void run() {

    	        // make sure we have something to play
    	        if (audioInputStream == null) {
    	          shutDown("No loaded audio to play back");
    	          return;
    	        }
    	        // reset to the beginnning of the stream
    	        try {
    	          audioInputStream.reset();
    	        } catch (Exception e) {
    	          shutDown("Unable to reset the stream\n" + e);
    	          return;
    	        }

    	        /* get an AudioInputStream of the desired format for playback

    	        AudioFormat.Encoding encoding = AudioFormat.Encoding.PCM_SIGNED;
    	        float rate = 16000.0f;
    	        int channels = 2;
    	        int frameSize = 4;
    	        int sampleSize = 16;
    	        boolean bigEndian = true;

    	        AudioFormat format = new AudioFormat(encoding, rate, sampleSize, channels, (sampleSize / 8)
    	            * channels, rate, bigEndian);
				*/
				
    	        AudioFormat format = getAudioFormat();
    	        
    	        AudioInputStream playbackInputStream = AudioSystem.getAudioInputStream(format,
    	            audioInputStream);

    	        if (playbackInputStream == null) {
    	          shutDown("Unable to convert stream of format " + audioInputStream + " to format " + format);
    	          return;
    	        }

    	        // define the required attributes for our line,
    	        // and make sure a compatible line is supported.

    	        DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
    	        if (!AudioSystem.isLineSupported(info)) {
    	          shutDown("Line matching " + info + " not supported.");
    	          return;
    	        }

    	        // get and open the source data line for playback.

    	        try {
    	          line = (SourceDataLine) AudioSystem.getLine(info);
    	          line.open(format, bufSize);
    	        } catch (LineUnavailableException ex) {
    	          shutDown("Unable to open the line: " + ex);
    	          return;
    	        }

    	        // play back the captured audio data

    	        int frameSizeInBytes = format.getFrameSize();
    	        int bufferLengthInFrames = line.getBufferSize() / 8;
    	        int bufferLengthInBytes = bufferLengthInFrames * frameSizeInBytes;
    	        byte[] data = new byte[bufferLengthInBytes];
    	        int numBytesRead = 0;

    	        // start the source data line
    	        line.start();

    	        while (thread != null) {
    	          try {
    	            if ((numBytesRead = playbackInputStream.read(data)) == -1) {
    	              break;
    	            }
    	            int numBytesRemaining = numBytesRead;
    	            while (numBytesRemaining > 0) {
    	              numBytesRemaining -= line.write(data, 0, numBytesRemaining);
    	            }
    	          } catch (Exception e) {
    	            shutDown("Error during playback: " + e);
    	            break;
    	          }
    	        }
    	        // we reached the end of the stream.
    	        // let the data play out, then
    	        // stop and close the line.
    	        if (thread != null) {
    	          line.drain();
    	        }
    	        line.stop();
    	        line.close();
    	        line = null;
    	        shutDown(null);
    	      }
    	    } // End class Playback
    	    
    	    /**
    	     * Saves data from the input channel and writes to the a wave file
    	     */   	    
            public void save() {

                AudioFormat audioFormat = getAudioFormat();
                
                byte audioData[] = out.toByteArray();
                if(out == null)
                	System.out.println("!!!");

                InputStream byteArrayInputStream = new ByteArrayInputStream(audioData);

                tempais = new AudioInputStream(byteArrayInputStream, audioFormat, audioData.length / audioFormat.getFrameSize());

                
                    try {
                        //File file = new File("C:\\");//(System.getProperty("user.dir"));
                        JFileChooser fc = new JFileChooser("C:\\");
                        FileNameExtensionFilter wavfilter = new FileNameExtensionFilter("WAVE Audio File", "wav","WAV");//设置默认文件选项
                        fc.addChoosableFileFilter(wavfilter);
                        fc.setFileSelectionMode(JFileChooser.FILES_ONLY );

                        //System.out.println("testing!");
                        /*fc.setFileFilter(new javax.swing.filechooser.FileFilter() {
                            public boolean accept(File f) {
                                if (f.isDirectory()) {
                                    return true;
                                }
                                return false;
                            }
                            public String getDescription() {
                                return "Save as .wav file.";
                            }
                        });*/
                        if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                        	File targetMidiFile;
                        	String filepath = fc.getSelectedFile().getAbsolutePath();
                        	if(filepath.endsWith(".wav"))
                        	{
                        		targetMidiFile = fc.getSelectedFile();
                        	}
                        	else
                        	{
                        		targetMidiFile = new File(filepath + ".wav");
                        	}
                            saveWaveFile(targetMidiFile);
                        }
                    } catch (SecurityException ex) {
                        ex.printStackTrace();
                    } catch (Exception ex) { 
                        ex.printStackTrace();
                    }
                }
            
            private void shutDown(String message) {
    	        if ((errStr = message) != null) {
    	          System.err.println(errStr);
    	        }
    	      }

            public void saveWaveFile(File file) {
                try {
                    AudioSystem.write(tempais, AudioFileFormat.Type.WAVE, file);
                } catch (SecurityException ex) { 
                    //JavaSound.showInfoDialog();
                } catch (Exception ex) { 
                    ex.printStackTrace(); 
                }
            }
        }
}