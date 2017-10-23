compile:
	javac com/edsand/Eview.java
  
jar:
	javac com/edsand/Eview.java
	jar cmvf META-INF/MANIFEST.MF Eview.jar com/edsand/*.class images/
	mkdir build 
	mv Eview.jar build/
	cp -R images/ build/
  
run:
	javac com/edsand/Eview.java
	jar cmvf META-INF/MANIFEST.MF Eview.jar com/edsand/*.class images/
	mv Eview.jar build/
	cp -R images/ build/
	java -jar build/Eview.jar
  
clean:
	rm com/edsand/*.class
	rm -rf build
