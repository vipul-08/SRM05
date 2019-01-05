/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Srm05A
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int tCases = sc.nextInt();
		String ans[] = new String[tCases];
		for(int i = 0 ; i < tCases ; i++) {
		    int numSystems = sc.nextInt();   // number of systems
		    int availableRepeaters = sc.nextInt();   // available routers
		    int availableWires = sc.nextInt();  // available wires
		    for(int j = 0 ; j < numSystems-1 ; j++) {
		        int distance = sc.nextInt();    // input the distances between systems
		        if(distance > 150) {   // if distance is greater than 150 router is required
		            availableRepeaters--;
		        }
		        availableWires -= distance; // available wire decreses as each computer connects
		    }
		    if(availableWires < 0 || availableRepeaters < 0) {    // if any of the repeters or wire are short in quantity then this condition is satisfied
		        ans[i] = "insufficient";
		    }
		    else {
		        ans[i] = "sufficient";
		    }
		}
		for(String i : ans) {
		    System.out.println(i);
		}
	}
}
