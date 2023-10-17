# Práctica 2: Algoritmos de Verificación

Elaborado por:
- Manjarrez Angeles Valeria Fernanda - 317234785
- Pedro Mendez Jose Manuel - 315073120
- Sánchez Reza Neider - 317020931

### Compilación

Para compilar el programa, simplemente se ejecuta `javac` en el archivo `CodingScheme.java`. Dentro del directorio `src/`, ejecutar:

    javac GraphCertificateGenerator.java
    
### Ejecución

Para ejecutar el programa, se usa la instrucción `java`. Es necesario indicar un archivo de entrada (con la gráfica codificada en texto) y un archivo de salida. Los archivos de entrada se encuentran dentro del directorio `examples/`.  

Se sugiere utilizar el mismo directorio para guardar los archivos de salida, aunque no es estrictamente necesario (puede especificarse cualquier ruta para el archivo de salida). Dentro del directorio `src/`, ejecutar:

    java GraphCertificateGenerator ./../examples/<example-n>.txt ./../examples/out_<example-n>.txt

Ejemplo:
    
    java GraphCertificateGenerator ./../examples/example1.txt ./../examples/out_example1.txt
Donde:
- El primer parámetro corresponde con la ruta del archivo de entrada que representa nuestro ejemplar. 
- El segundo parámetro corresponde con la ruta del archivo de salida. Puede usarse cualquier ruta y cualquier archivo (si no existe, se crea). Se sugiere utilizar el mismo directorio `examples/` y utilizar un archivo con extensión `.txt`.
- `<example-n>` se puede sustituir por el nombre de archivo de alguno de los archivos presentes en el directorio `examples/`. 

### Salida

# POR EDITAR
Una vez que se ha ejecutado el programa, se mostrará en pantalla dos secciones:
1. La primera corresponde con la lectura del archivo de entrada. En esta, se especifica el número de aristas y el número de vértices encontrados en el archivo de entrada.
2. La segunda corresponde con la escritura del ejemplar en el archivo de salida. Se indican el número de vértices, de aristas y el valor del parámetro `K`, además de un mensaje que indica que el archivo se escribió adecuadamente. 
