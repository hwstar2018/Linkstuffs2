@ECHO OFF

@ECHO Stopping Linkstuffs ...
net stop linkstuffs

@ECHO Uninstalling Linkstuffs ...
"%~dp0"linkstuffs.exe uninstall

@ECHO DONE.