# Microsoft Developer Studio Generated NMAKE File, Format Version 4.20# ** DO NOT EDIT **# TARGTYPE "Java Virtual Machine Java Workspace" 0x0809!IF "$(CFG)" == ""CFG=Nuke - Java Virtual Machine Debug!MESSAGE No configuration specified.  Defaulting to Nuke - Java Virtual Machine\ Debug.!ENDIF !IF "$(CFG)" != "Nuke - Java Virtual Machine Release" && "$(CFG)" !=\ "Nuke - Java Virtual Machine Debug"!MESSAGE Invalid configuration "$(CFG)" specified.!MESSAGE You can specify a configuration when running NMAKE on this makefile!MESSAGE by defining the macro CFG on the command line.  For example:!MESSAGE !MESSAGE NMAKE /f "Nuke.mak" CFG="Nuke - Java Virtual Machine Debug"!MESSAGE !MESSAGE Possible choices for configuration are:!MESSAGE !MESSAGE "Nuke - Java Virtual Machine Release" (based on\ "Java Virtual Machine Java Workspace")!MESSAGE "Nuke - Java Virtual Machine Debug" (based on\ "Java Virtual Machine Java Workspace")!MESSAGE !ERROR An invalid configuration is specified.!ENDIF !IF "$(OS)" == "Windows_NT"NULL=!ELSE NULL=nul!ENDIF ################################################################################# Begin ProjectJAVA=jvc.exe!IF  "$(CFG)" == "Nuke - Java Virtual Machine Release"# PROP BASE Use_MFC 0# PROP BASE Use_Debug_Libraries 0# PROP Use_MFC 0# PROP Use_Debug_Libraries 0OUTDIR=.INTDIR=.ALL : "$(OUTDIR)\Nuke.class"CLEAN : 	-@erase "$(INTDIR)\Nuke.class"# ADD BASE JAVA /O# ADD JAVA /O!ELSEIF  "$(CFG)" == "Nuke - Java Virtual Machine Debug"# PROP BASE Use_MFC 0# PROP BASE Use_Debug_Libraries 1# PROP Use_MFC 0# PROP Use_Debug_Libraries 1OUTDIR=.INTDIR=.ALL : "$(OUTDIR)\Nuke.class"CLEAN : 	-@erase "$(INTDIR)\Nuke.class"# ADD BASE JAVA /g# ADD JAVA /g!ENDIF ################################################################################# Begin Target# Name "Nuke - Java Virtual Machine Release"# Name "Nuke - Java Virtual Machine Debug"!IF  "$(CFG)" == "Nuke - Java Virtual Machine Release"!ELSEIF  "$(CFG)" == "Nuke - Java Virtual Machine Debug"!ENDIF ################################################################################# Begin Source FileSOURCE=.\Nuke.java!IF  "$(CFG)" == "Nuke - Java Virtual Machine Release""$(INTDIR)\Nuke.class" : $(SOURCE) "$(INTDIR)"!ELSEIF  "$(CFG)" == "Nuke - Java Virtual Machine Debug""$(INTDIR)\Nuke.class" : $(SOURCE) "$(INTDIR)"!ENDIF # End Source File# End Target# End Project################################################################################