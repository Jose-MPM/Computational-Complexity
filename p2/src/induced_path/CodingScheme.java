package induced_path;

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
	
	int[][] matrix = textToMatrix(args[0]);
    }

    /**
     * Transforms a graph from a text-based coding scheme, to a matrix-based one.
     * The coding scheme corresponds to the adyacency matrix of the graph.
     * This method also writes the matrix-based coded graph into the specified
     * file path.
     *
     * @param in  the path to the input file, which contains a graph coded
     *        in plain text.
     */
    public static int[][] textToMatrix(String in){
	try{
	    File graph = new File(in);
	    Scanner sc = new Scanner(graph);

	    // Retrieving the K value.
	    int kVal = sc.nextInt();

	    // Retrieving the number of vertices.
	    if(!sc.hasNext()){
		System.out.println("Null graph not valid. No changes were made.");
		return null;
	    }

	    String vertexList = sc.next();
	    String[] vertices = vertexList.split(",");
	    int noVertex = Integer.parseInt(vertices[vertices.length - 1]);

	    if(kVal >= noVertex){
		System.out.println("K value not valid: K es greater than total vertexes. No changes were made.");
		return null;
	    }

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

	    return matrix;

	} catch (FileNotFoundException e){
	    System.out.println("Some of the files were not found. Please specify another file path. No changes were made.");
	    return null;
	}
	
    }

}
