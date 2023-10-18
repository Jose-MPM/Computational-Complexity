# Práctica 2: Algoritmos de Verificación

Elaborado por:
- Manjarrez Angeles Valeria Fernanda - 317234785
- Pedro Mendez Jose Manuel - 315073120
- Sánchez Reza Neider - 317020931

## Compilación

Para compilar el programa, simplemente se ejecuta la instrucción `javac` sobre los archivos `.java` del paquete `induced_path`. Es decir, desde el directorio raíz del proyecto (donde se encuentra este archivo `Readme`), ejecutar:
    
    cd src/

    javac induced_path/*.java
    
## Ejecución 

### Generación de certificados

Para ejecutar el programa, se usa la instrucción `java`. Es necesario indicar un archivo de entrada (con la gráfica codificada en texto) y un archivo de salida que representará nuestro certificado. Los archivos de entrada se encuentran dentro del directorio `examples/graphs`.  

Se sugiere utilizar el directorio `examples/certificates` para guardar los archivos de salida, aunque no es estrictamente necesario (puede especificarse cualquier ruta para el archivo de salida). Dentro del directorio `src/`, ejecutar:

    java induced_path.GraphCertificateGenerator ./../examples/graphs/<exampleN>.txt ./../examples/certificates/<exampleN>_<certN>.txt
    
Donde:
* `<exampleN>` corresponde con el nombre del archivo de entrada.
* `<exampleN>_<certN>` corresponde con el nombre del archivo de salida.

Por ejemplo, al ejecutar la siguiente línea (desde el directorio `src/`)
    
    java induced_path.GraphCertificateGenerator ./../examples/graphs/example1.txt ./../examples/certificates/example1_cert1.txt
    
Produce el archivo `examples/certificates/example1_cert1.txt` cuya única línea corresponde con el certificado generado aleatoriamente para la gráfica codificada en el archivo `examples/graphs/example1.txt`

#### Salida

Una vez que se ha ejecutado el programa, se mostrará en pantalla dos secciones:
1. La primera corresponde con la lectura del archivo de entrada. En esta, se especifica el número de aristas y el número de vértices encontrados en el archivo de entrada.
2. La segunda corresponde con la escritura del certificado en el archivo de salida. Se indican el número de vértices, de aristas y el valor del parámetro `K`, el certificado generado, además de un mensaje que indica que el archivo se escribió adecuadamente.


### Algoritmo de verificación
De manera similar, el programa de verificación se ejecuta con la instrucción `java`. En este caso, es necesario especificar el archivo que contiene la codificación de la gráfica (codificación basada en texto) y el archivo que contiene el certificado. Como se usarán los mismos ejemplares y los certificados generados por el programa anterior, los archivos necesarios se encuentran en el directorio `examples/`.  
Es decir, dentro del directorio `src/`, ejecutar:

    java induced_path.ValidationAlgorithm ./../examples/graphs/<exampleN>.txt ./../examples/certificates/<exampleN>_<certN>.txt
    
Donde:
* `<exampleN>` corresponde con el nombre del archivo de codificación de la gráfica.
* `<exampleN>_<certN>` corresponde con el nombre del archivo de la codificación del certificado.

Por ejemplo, al ejecutar la siguiente línea (desde el directorio `src/`) _luego de haber ejecutado el programa anterior_,

    java induced_path.ValidationAlgorithm ./../examples/graphs/example1.txt ./../examples/certificates/example1_cert1.txt
    
Se muestra la salida del programa, descrita a continuación.

#### Salida
Una vez se ha ejecutado el programa, se muestran:
1. La codificación en matriz de la gráfica leída.
2. El valor del parámetro `K`.
3. La respuesta de la verificación, es decir, si el certificado dado es solución al problema con la gráfica de entrada.
