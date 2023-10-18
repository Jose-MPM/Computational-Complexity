package induced_path;

import java.util.Scanner;
import java.io.File;

/**
 * Implements methods to validate if a certificate is solution to the induced
 * path problem.
 *
 * @author neider
 * @version 17/10/2023
 */
public class ValidationAlgorithm{

    /**
     * Manages the program execution.
     */
    public static void main(String[] args){

	validator(args[0], args[1]);

    }

    /**
     * Validate if a given certificate (list of vertices) is solution to the
     * induced path problem, in the specified graph.
     *
     * @param 
     */
    public static void validator(String graph, String certIn){

	System.out.println("\nReading the file " + graph);

	// Retrieves graph matrix-based codification (uses code from previous pract. 1).
	int[][] matrix = CodingScheme.textToMatrix(graph);
	if(matrix == null){
	    System.out.println("Couldn't read the specified graph.");
	    return;
	}

	System.out.println("\nRead graph:");
	for(int i = 0; i < matrix.length; i++){
	    for(int j = 0; j < matrix[i].length; j++){
		System.out.print("" + matrix[i][j] + " ");
	    }
	    System.out.print("\n");
	}

	try{
	    File certFile = new File(certIn);
	    Scanner sc = new Scanner(certFile);

	    // Retrieves the generated certificate, as an int array.
	    String vertexListStrings = sc.nextLine();
	    String[] vertexesStrings = vertexListStrings.split(",");
	    String certString = String.join(",", vertexesStrings);
	    
	    int[] vertexes = new int[vertexesStrings.length];
	    for(int i = 0; i < vertexes.length; i++){
		vertexes[i] = Integer.parseInt(vertexesStrings[i]);
	    }

	    // VERIFICATION ALGORITHM
	    boolean originVisited = false;
	    for(int i = 0; i < vertexes.length; i++){
		originVisited = false;
		int org = vertexes[i] - 1;
		for(int j = i + 1; j < vertexes.length; j++){
		    int dest = vertexes[j] - 1;
		    if(matrix[org][dest] == 1){
			if(originVisited){
			    System.out.println("\nThe given certificate " + certString + " is NOT a valid solution.");
			    return;
			}
			else originVisited = true;
		    }
		}
	    }
	    System.out.println("\nThe certificate " + certString + " IS a valid solution.");
	} catch (Exception e){
	    System.out.println(e);
	}
	
    }

}
