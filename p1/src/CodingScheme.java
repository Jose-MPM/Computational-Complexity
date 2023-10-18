import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;               /* Allows file writing. */
import java.io.FileNotFoundException;    /* Necessary to read/write files. */
import java.io.IOException;              /* Necessary to read/write files. */

/**
 * Implements methods to transform graphs between coding schemes.
 *
 * @author neider
 * @author Pedro Mendez Jose Manuel
 * @version 17/09/2023
 */
public class CodingScheme{

    /**
     * Manages the program execution.
     */
    public static void main(String[] args){
	
	readGraph(args[0]);

	textToMatrix(args[0], args[1]);
    }

    /**
     * Allows reading of a coded graph.
     *
     * @param in  file path with the coded representation of a graph.
     */
    public static void readGraph(String in){
	System.out.println("-------------------------------------------------------------");
	System.out.println("Reading the text-based coded representation of the graph.");
	System.out.println("-------------------------------------------------------------");
	
	try {
	    File dataG = new File(in);
	    Scanner scE = new Scanner(dataG); 
	    int numEdges = -2;
	    while(scE.hasNext()){
		// Calculates the number of edges
		numEdges = numEdges+1;
		scE.nextLine();
	    }
	    System.out.println("Number of Edges: "+ numEdges);
	    Scanner scV = new Scanner(dataG); 

	    // Read the first line and extract the value of K
	    int kValue = scV.nextInt();
            
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
	    System.out.println("Number of Vertices: "+nOfV);
	} catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Transforms a graph from a text-based coding scheme, to a matrix-based one.
     * The coding scheme corresponds to the adyacency matrix of the graph.
     * This method also writes the matrix-based coded graph into the specified
     * file path.
     *
     * @param in  the path to the input file, which contains a graph coded
     *        in plain text.
     * @param out  the path to the file which the matrix coded graph will be
     *        written.
     */
    public static void textToMatrix(String in, String out){
	System.out.println("\n-------------------------------------------------------------");
	System.out.println("Writing the matrix-based coded representation of the graph.");
	System.out.println("-------------------------------------------------------------");
	
	try{
	    File graph = new File(in);
	    Scanner sc = new Scanner(graph);

	    // Retrieving the K value.
	    int kVal = sc.nextInt();

	    // Retrieving the number of vertices.
	    if(!sc.hasNext()){
		System.out.println("Null graph not valid. No changes were made.");
		return;
	    }

	    String vertexList = sc.next();
	    String[] vertices = vertexList.split(",");
	    int noVertex = Integer.parseInt(vertices[vertices.length - 1]);

	    int[][] matrix = new int[noVertex][noVertex];

	    // Building the matrix from the edges list.
	    int edgeTotal = 0;
	    
	    while(sc.hasNext()){
		String edgeLine = sc.next();
		edgeTotal++;
		String[] pair = edgeLine.split(",");
		
		// Assumed pair.length == 2.
		int org = Integer.parseInt(pair[0]);
		int dest = Integer.parseInt(pair[1]);
		matrix[org - 1][dest - 1] = 1;
		matrix[dest - 1][org - 1] = 1;
	    }
	    
	    System.out.println("Number of vertices: " + noVertex);
	    System.out.println("Number of edges: " + edgeTotal);
	    System.out.println("Parameter K value: " + kVal);

	    // Writes the corresponding values into the output file.
	    File graphMatrix = new File(out);
	    FileWriter fw = new FileWriter(graphMatrix);
	    for(int i = 0; i < matrix.length; i++){
		for(int j = 0; j < matrix[i].length; j++){
		    fw.write("" + matrix[i][j] + " ");
		}
		fw.write(String.format("%n"));
	    }
	    fw.write("" + kVal);

	    sc.close();
	    fw.close();

	    System.out.println("\nCoded representation of graph has been written in file " + out);

	} catch (FileNotFoundException e){
	    System.out.println("Some of the files were not found. Please specify another file path. No changes were made.");
	} catch (IOException ioe){
	    System.out.println("Failed to write in the specified file. No changes were made.");
	}
	
    }

}
