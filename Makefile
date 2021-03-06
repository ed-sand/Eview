#!/bin/bash


compile:
	javac com/edsand/Eview.java
  
jar:
	javac com/edsand/Eview.java;
	if [ ! -f Eview_RELEASE.1.0.1.jar ];\
		then	jar cmvf META-INF/MANIFEST.MF Eview_RELEASE.1.0.1.jar\
		               com/edsand/*.class icon.png;	\
	fi
	if [ ! -d build/ ];\
		then	mkdir build/ &&	mkdir build/Eview/;\
	fi
	mv Eview_RELEASE.1.0.1.jar build/Eview
	cp -R images/ build/Eview
  
run:
	javac com/edsand/Eview.java;
	if [ ! -f Eview_RELEASE.1.0.1.jar ];\
		then	jar cmvf META-INF/MANIFEST.MF Eview_RELEASE.1.0.1.jar\
		               com/edsand/*.class icon.png;	\
	fi
	if [ ! -d build/ ];\
		then	mkdir build/ &&	mkdir build/Eview/;\
	fi
	mv Eview_RELEASE.1.0.1.jar build/Eview
	cp -R images/ build/Eview
	java -jar build/Eview/Eview_RELEASE.1.0.1.jar
  
zip:
	javac com/edsand/Eview.java;
	if [ ! -f Eview_RELEASE.1.0.1.jar ];\
		then	jar cmvf META-INF/MANIFEST.MF Eview_RELEASE.1.0.1.jar\
		               com/edsand/*.class icon.png;	\
	fi
	if [ ! -d build/ ];\
		then	mkdir build/ &&	mkdir build/Eview/;\
	fi
	mv Eview_RELEASE.1.0.1.jar build/Eview
	cp -R images/ build/Eview
	if [ ! -f Eview_RELEASE.1.0.1.zip ];\
		then	cd build && zip -r Eview_RELEASE.1.0.1.zip Eview\
		      && mv Eview_RELEASE.1.0.1.zip ../;\
	fi

clean-git:
	if [ -d build/ ];\
		then	rm -rf build/;\
	fi
	if [ -f com/edsand/Eview.class ];\
		then	rm -rf com/edsand/*.class;\
	fi
	
clean:
	if [ -d build/ ];\
		then	rm -rf build/;\
	fi
	if [ -f com/edsand/Eview.class ];\
		then	rm -rf com/edsand/*.class;\
	fi
	if [ -f Eview_RELEASE.1.0.1.zip ];\
		then	rm -rf Eview_RELEASE.1.0.1.zip;\
	fi
