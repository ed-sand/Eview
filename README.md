# Eview
Visor de imagenes en Java

Uso la linea de comandos (Ubuntu Linux 17.04 x64) para compilar y ejecutar el 
programa.

#! No tengo integracion con NetBeans aun.

INSTRUCCIONES:

Descargar proyecto:

  	git clone https://github.com/ed-sand/Eview.git

Compilar classes:

	LINUX / UNIX / MacOSX:

		cd Eview/
		make compile

	WINDOWS
    
		cd Eview\src
		javac com\edsand\Eview.java
		java com\edsand\Eview
    

Crear JAR:

	LINUX / UNIX / MacOSX:

		cd Eview/
		make jar
      
	WINDOWS
    
		cd Eview\src
		javac com\edsand\Eview.java
		jar cmvf META-INF\MANIFEST.MF Eview.jar com\edsand\\*.class images\
		java -jar Eview.jar
      
Correr JAR:

	LINUX / UNIX / MacOSX:
		
		cd Eview/
		make run
      
Limpiar directorio:

	LINUX / UNIX / MacOSX:
		
		cd Eview/
		make clean

Crear zip del proyecto:

	LINUX / UNIX / MacOSX:
		
		cd Eview/
		make zip

TODO: Respetar proporciones de imagenes al dibujar al JPanel.

TODO: Agregar script para manejar RELEASES facilmente.

TODO: Cargar imagenes JIT (Just In Time) para no desperdiciar recursos.

TODO: Integracion con Netbeans.

TODO: Hacerlo bonito :v (Me han dicho que esta feo :c)

TODO: Agregar un ActionListener que responda a las flechas direccionales y 
cambie de imagen.

TODO: Decrementar imagenes hacia los extremos.

TODO: Difuminar bordes de extremos.

TODO: Tornar transparente el JFrame.

TODO: Agregar icono de programa.

TODO: Agregar zoom.

TODO: Agregar filtros.

TODO: Agregar configuracion de directorios personalizados.
