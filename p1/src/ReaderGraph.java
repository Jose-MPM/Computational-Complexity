/**
 * Class that allows reading a coding of a graph.
 * 
 * @version 1.1
 * @author Pedro Mendez Jose Manuel
 */

import java.util.Scanner;
import java.io.File;

public class ReaderGraph{

	public static void main(String[] args) {
		try {
			File dataG = new File(args[0]);
			Scanner scE = new Scanner(dataG); 
			int numEdges = -2;
			while(scE.hasNext()){ // Calculates the number of edges
	           	numEdges = numEdges+1;
	           	scE.nextLine();
	       	}
	        System.out.println("Number of Edges: "+ numEdges);
	        Scanner scV = new Scanner(dataG); 

			// Read the first line and extract the value of K
	        String lineK = scV.nextLine();
	        int indexOfEquals = lineK.indexOf('='); // Find the index of '='

	        if (indexOfEquals != -1) { // Check if '=' is found
                String kValue = lineK.substring(indexOfEquals + 1).trim(); // Extract the value after '='
                System.out.println("Value K: " + kValue);
            } else {
                System.out.println("No value of K found.");
            }
            
	        String line = scV.nextLine();
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
}