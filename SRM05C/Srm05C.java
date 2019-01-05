import java.util.*;
class Srm05C {
    @SuppressWarnings({"unchecked","deprecation"})
    public static void main(String[] args) {
    	
        Scanner sc = new Scanner(System.in);
        int tCases = sc.nextInt();
    	String ans[] = new String[tCases];
    	
        for( int i = 0 ; i < tCases ; i++ ) {
        	int numVertices = sc.nextInt();    // number of vertices input
    		int numConnections = sc.nextInt();    // number of edges or connections input
            int totalNeighboursInstalled = 0;     // the number of vertices whose neighbours are colored
            ArrayList<Integer> srcList = new ArrayList<>(); // arrayList to keep track of all the sources of edges
            ArrayList<Integer> destList = new ArrayList<>();    // arrayList to keep track of all the destinations of edges

            // Declarations of adjacency list array , color list array , visited array and colored neighbours array
            LinkedList<Integer> adjacencyListArray[] = new LinkedList[numVertices];
    		char osList[] = new char[numVertices];
            boolean visited[] = new boolean[numVertices];

            // Initializations of adjacency list array , color list array , visited array and colored neighbours array
    		for(int j = 0 ; j < numVertices ; j++) {
    			osList[j] = 'n';
                adjacencyListArray[j] = new LinkedList<>(); 
    			visited[j] = false;
    		}

            // Input the graph and representation in adjacency list, source list and destination list
    		for(int j = 0 ; j < numConnections ; j++) {

                int src = sc.nextInt();
    			int dest = sc.nextInt();
                
                adjacencyListArray[src-1].add(dest-1);
                adjacencyListArray[dest-1].add(src-1);

                srcList.add(src-1);
                destList.add(dest-1);

    		}

    		osList[0] = 'l';   // Assuming the OS of first computer as Linux
    		boolean contradiction = false;    // Declaration and initialization of contradiction
    		visited[0] = true;    // Visit the first node
    		
			ArrayList<Integer> notInstalled = new ArrayList<Integer>(); // iniatialize the list of vertices with notInstalled neighbours
			notInstalled.add(0);    // mark neighbours of first node notInstalled
            // Following loop will run until neighbours of all the vertices are colored
            while( totalNeighboursInstalled < numVertices ) {
				
    			for( int j = 0 ; j < notInstalled.size() ; j++) {

    				if( visited[notInstalled.get(j)] ) {

    					for(int k = 0 ; k < adjacencyListArray[notInstalled.get(j)].size() ; k++) {

                            if(!(visited[adjacencyListArray[notInstalled.get(j)].get(k)])){

                                int p = adjacencyListArray[notInstalled.get(j)].get(k); // neighbour of current vertex
                                osList[p] = (osList[notInstalled.get(j)] == 'l') ? 'w' : 'l'; // OS of neighbour will be the reverse OS of current computer
                                visited[p] = true;
                                notInstalled.add(p);

                            }

    					}

						notInstalled.remove(new Integer(notInstalled.get(j)));
                        totalNeighboursInstalled++;
						j--;
    				
                    }

    			}
				
                if(notInstalled.size() == 0) {

					for(int j = 0 ; j < numVertices ; j++) {

						if(!visited[j]) {

							notInstalled.add(j);
							visited[j] = true;
							osList[j] = 'l';
							break;
						
                        }
					}
				}

                // Check for contradiction after each iteration of coloring
    			if( !findContradiction(srcList,destList,osList) ) {
					ans[i] = "no"; // Not a valid bipartite graph
					contradiction = true;
					break;
				}
    		}

            // Below condition will be satisfied if there was no contradiction in any iteration
    		if(!contradiction) {
    			ans[i] = "yes";
    		}
    	}
    	for( String i : ans){
    		System.out.println(i);
    	}
    }

    // This method will check for any contradiction
    static boolean findContradiction(ArrayList<Integer> srcList, ArrayList<Integer> destList , char[] osList) {
        for(int i = 0 ; i < srcList.size() ; i++) {
            if(osList[srcList.get(i)] == 'n' || osList[destList.get(i)] == 'n')
                continue;   // color of any vertex is not assigned then the edge will be skipped
            else if(osList[srcList.get(i)] == osList[destList.get(i)])
                return false;   // color of neighbours are same then contradiction found   
        }
        return true;
    }
}
