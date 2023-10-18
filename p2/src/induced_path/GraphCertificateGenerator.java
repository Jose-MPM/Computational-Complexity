package induced_path;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.io.File;
import java.io.FileWriter;               /* Allows file writing. */
import java.io.FileNotFoundException;    /* Necessary to read/write files. */
import java.io.IOException;              /* Necessary to read/write files. */

/**
 * Implements methods to generate and understand a certificate.
 * 
 * @author Manjarrez Angeles Valeria Fernanda
 * @author Pedro Mendez Jose Manuel
 * @author Sanchez Reza Neider
 * @version 17/10/2023
 */
public class GraphCertificateGenerator{

    /**
     * Manages the program execution.
     * 
     * The main method takes two arguments
     * the input file path and the output file path. 
     * It then calls the certificateGenerator method to generate a certificate and 
     * the decodeCertificate method to decode the generated certificate.
     */
    public static void main(String[] args){
	if (args.length != 2) {
            System.out.println("Por favor proporcione el nombre del archivo de entrada y el nombre del archivo de salida.");
            return;
        }

        String inputFilePath = args[0];
        String outputFilePath = args[1];

        certificateGenerator(inputFilePath, outputFilePath);
	int[] certificateArray = decodeCertificate(outputFilePath);
    	System.out.println("Array que representa nuestro Certificado(aleatorio): " + Arrays.toString(certificateArray));
	//certificateGenerator("./../examples/example1.txt", "./../examples/certificate_output.txt");
    }

    /**
     * Allows reading of a coded graph and return a certificate.
     *
     * @param in  file path with the coded representation of a graph.
     * @param out file path were we r going to save the certificate generated with almost and max k vertex 
     */
    public static void certificateGenerator(String in, String out){
	System.out.println("-----------------------------------------------------------------------------");
	System.out.println("Reading the text-based coded representation of the graph(the exemplar).");
	System.out.println("-----------------------------------------------------------------------------");
	try {
	    File dataG = new File(in);
	    Scanner scE = new Scanner(dataG); 
	    int numEdges = -2;
	    while(scE.hasNext()){
		// Calculates the number of edges
		numEdges = numEdges+1;
		scE.nextLine();
	    }
	    scE.close();

	    Scanner scV = new Scanner(dataG); 
	    int kValue = scV.nextInt(); // Read the first line and extract the value of K
				
	    String line = scV.next();
	    String[] strV = line.split(",");
	    int[] v = new int[strV.length];
	    int count = 0;
	    int nOfV = v.length;
	    for(int i = 0; i < nOfV; i++){
		v[i] = Integer.parseInt(strV[i]);
		count = count + 1;
	    }	
	    scV.close();
	    // Generating the certificate
	    System.out.println("\n-------------------------------------------------------------");
	    System.out.println("Generating the certificate.");
	    System.out.println("-------------------------------------------------------------");
            Set<Integer> selectedIndices = new HashSet<>();
	    Set<Integer> selectedVertices = new HashSet<>();
            Random random = new Random();
			
	    // to dont have a bucle
	    if (kValue <= nOfV){
		while (selectedIndices.size() < kValue) {
		    int randomIndex = random.nextInt(v.length);
		    if (!selectedIndices.contains(randomIndex)) {
			selectedIndices.add(randomIndex);
			selectedVertices.add(v[randomIndex]);
		    }
		}
	    }

            StringBuilder certificate = new StringBuilder();
            for (Integer vertex : selectedVertices) {
                certificate.append(vertex);
                certificate.append(",");
            }
            certificate.deleteCharAt(certificate.length() - 1); // Remove the trailing comma

            // Writing the certificate to the output file
            FileWriter fw = new FileWriter(out);
            fw.write(certificate.toString());
            fw.close();

	    System.out.println("Number of Vertices: "+nOfV);
	    System.out.println("Number of Edges: "+ numEdges);
	    System.out.println("Parameter K value: " + kValue);
	    System.out.println("Certificate generated: " + certificate.toString());
            System.out.println("Certificate saved to file: " + out);
	} catch (Exception e) {
	    System.out.println(e);
	}
	System.out.println("-------------------------------------------------------------");
    }

    /**
     * Allows reading of a coded graph.
     * The decodeCertificate method reads a text-based coded 
     * representation of a certificate from a file, 
     * converts it into an array of integers
     * and returns the array.
     *
     * @param in  file path with the coded representation of a graph.
     */
    public static int[] decodeCertificate(String in){
	System.out.println("-------------------------------------------------------------");
	System.out.println("Reading the text-based coded representation of the Certificate.");
	System.out.println("-------------------------------------------------------------");

	try { 
	    File dataG = new File(in);
	    Scanner scanner = new Scanner(dataG);

	    String line = scanner.nextLine();
	    String[] strArray = line.split(",");
	    int[] numbers = new int[strArray.length];
	    for (int i = 0; i < strArray.length; i++) {
		numbers[i] = Integer.parseInt(strArray[i]);
	    }

	    //Arrays.sort(numbers);
	    return numbers;
	} catch (Exception e) {
	    System.out.println(e);
	    return new int[0]; // Retorna un arreglo vacío si ocurre alguna excepcion.
	}
    }
}
