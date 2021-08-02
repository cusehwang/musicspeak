@echo off
setlocal

cd ..
set HOME="%cd%\MusicSpeak"
set PATH=%HOME%;%PATH%
set CLASSPATH=MusicSpeak_LowRL.jar;%CLASSPATH%
set CLASSPATH=%HOME%\cgjsapi.jar;%CLASSPATH%
set CLASSPATH=.;%CLASSPATH%
echo %CLASSPATH%
set CMUPATH=%HOME%\cmudict.0.7a
set FWLPATH=%HOME%\FunctionWords.txt
set RCPATH=%HOME%\pics\MS.jpg
set RECBPATH=%HOME%\pics\recb.png
set PLAYBPATH=%HOME%\pics\playb.png
set STOPBPATH=%HOME%\pics\stopb.png
set SAVEBPATH=%HOME%\pics\saveb.png
set HCCLLOGOPATH=%HOME%\pics\hccl.jpg
set CUHKLOGOPATH=%HOME%\pics\cuhk.jpg
set RHYTHMBPATH=%HOME%\pics\rhythm_120.png
cd MusicSpeak


rem java -DCMUPATH=%CMUPATH% -DFWLPATH=%FWLPATH% -DRCPATH=%RCPATH% -DRECBPATH=%RECBPATH% -DPLAYBPATH=%PLAYBPATH% -DSTOPBPATH=%STOPBPATH% -DSAVEBPATH=%SAVEBPATH% -DHCCLLOGOPATH=%HCCLLOGOPATH% -DCUHKLOGOPATH=%CUHKLOGOPATH% -DRHYTHMBPATH=%RHYTHMBPATH% MusicSpeak

start javaw -DCMUPATH=%CMUPATH% -DFWLPATH=%FWLPATH% -DRCPATH=%RCPATH% -DRECBPATH=%RECBPATH% -DPLAYBPATH=%PLAYBPATH% -DSTOPBPATH=%STOPBPATH% -DSAVEBPATH=%SAVEBPATH% -DHCCLLOGOPATH=%HCCLLOGOPATH% -DCUHKLOGOPATH=%CUHKLOGOPATH% -DRHYTHMBPATH=%RHYTHMBPATH% MusicSpeak

endlocal