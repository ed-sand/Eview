# Eview
Visor de imagenes en Java

Uso la linea de comandos (Ubuntu Linux 17.04 x64) para compilar y ejecutar el programa.

#! No tengo integracion con NetBeans aun.

INSTRUCCIONES:

Descargar proyecto:

    git clone https://github.com/ed-sand/Eview.git

Compilar classes:

    LINUX / UNIX / MacOSX:

      cd Eview/src/

      javac com/edsand/Eview.java

      java com/edsand/Eview

    WINDOWS
    
      cd Eview\src

      javac com\edsand\Eview.java

      java com\edsand\Eview
    

CREAR JAR:

    LINUX / UNIX / MacOSX:

      cd Eview/src/

      javac com/edsand/Eview.java

      jar cmvf META-INF/MANIFEST.MF Eview.jar com/edsand/*.class com/images/

      java -jar Eview.jar

    WINDOWS
    
      cd Eview\src

      javac com\edsand\Eview.java

      jar cmvf META-INF\MANIFEST.MF Eview.jar com\edsand\\*.class com\images\

      java -jar Eview.jar

TODO: Cargar las imagenes JIT (Just In Time) para no desperdiciar recursos.

TODO: Integracion con Netbeans.
