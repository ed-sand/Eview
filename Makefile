#!/bin/bash

compile:
	javac com/edsand/Eview.java
  
jar:
	if [ ! -f com/edsand/Eview.class ];	then	javac com/edsand/Eview.java;	fi
	if [ ! -f Eview_RELEASE.1.0.0.jar ];	then	jar cmvf META-INF/MANIFEST.MF Eview_RELEASE.1.0.0.jar com/edsand/*.class images/;	fi
	if [ ! -d build/ ];	then	mkdir build/ &&	mkdir build/Eview/;	fi
	mv Eview_RELEASE.1.0.0.jar build/Eview
	cp -R images/ build/Eview
  
run:
	if [ ! -f com/edsand/Eview.class ];	then	javac com/edsand/Eview.java;	fi
	if [ ! -f Eview_RELEASE.1.0.0.jar ];	then	jar cmvf META-INF/MANIFEST.MF Eview_RELEASE.1.0.0.jar com/edsand/*.class images/;	fi
	if [ ! -d build/ ];	then	mkdir build/ &&	mkdir build/Eview/;	fi
	mv Eview_RELEASE.1.0.0.jar build/Eview
	cp -R images/ build/Eview
	java -jar build/Eview/Eview_RELEASE.1.0.0.jar
  
zip:
	if [ ! -f com/edsand/Eview.class ];	then	javac com/edsand/Eview.java;	fi
	if [ ! -f Eview_RELEASE.1.0.0.jar ];	then	jar cmvf META-INF/MANIFEST.MF Eview_RELEASE.1.0.0.jar com/edsand/*.class images/;	fi
	if [ ! -d build/ ];	then	mkdir build/ &&	mkdir build/Eview/;	fi
	mv Eview_RELEASE.1.0.0.jar build/Eview
	cp -R images/ build/Eview
	if [ ! -f Eview_RELEASE.1.0.0.zip ]; then	zip -r Eview_RELEASE.1.0.0.zip build/Eview; fi

clean-git:
	if [ -d build/ ];	then	rm -rf build/;	fi
	if [ -f com/edsand/Eview.class ];	then	rm -rf com/edsand/*.class;	fi
	
clean:
	if [ -d build/ ];	then	rm -rf build/;	fi
	if [ -f com/edsand/Eview.class ];	then	rm -rf com/edsand/*.class;	fi
	if [ -f Eview_RELEASE.1.0.0.zip ];	then	rm -rf Eview_RELEASE.1.0.0.zip;	fi
