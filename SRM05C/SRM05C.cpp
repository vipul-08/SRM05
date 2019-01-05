#include <bits/stdc++.h>
#define vi vector <int>
#define vc vector <char>
#define vb vector <bool>
#define vvi vector < vector <int> >
#define pb push_back

using namespace std;

bool findContradiction(vi sList , vi dList , vc oList) {
    for(int i = 0 ; i < sList.size() ; i++) {
        if(oList[sList[i]] == 'n' || oList[dList[i]] == 'n'){
            continue;
        }
        else if(oList[sList[i]] == oList[dList[i]]) {
            return false;
        }
    }
    return true;
}

int main() {
	int t;
	cin>>t;
	string ans[t];
	for(int i = 0 ; i < t ; i++) {
	    int numVertices , numConnections;
	    cin>>numVertices>>numConnections;
	    int totalNeighboursInstalled = 0;
	    vi srcList;
	    vi destList;
	    vvi adjacencyList;
	    vc osList;
	    vb visited;
	    for(int j = 0 ; j < numVertices ; j++) {
	        vi dummy;
	        osList.pb('n');
	        adjacencyList.pb(dummy);
	        visited.pb(false);
	    }
	    for(int j = 0 ; j < numConnections ; j++) {
	        int src,dest;
	        cin>>src>>dest;
	        adjacencyList[src-1].push_back(dest-1);
	        adjacencyList[dest-1].push_back(src-1);
	        srcList.pb(src-1);
	        destList.pb(dest-1);
	    }
	    osList[0] = 'l';
	    bool contradiction = false;
	    visited[0] = true;
	    
	    vi notInstalled;
	    notInstalled.pb(0);
	    
	    while(totalNeighboursInstalled < numVertices) {
	        int j = 0;
	        while(j < notInstalled.size()) {
	            if(visited[notInstalled[j]] == true) {
	                for(int k = 0 ; k < adjacencyList[notInstalled[j]].size() ; k++) {
	                    if(visited[adjacencyList[notInstalled[j]][k]] == false) {
	                        int p = adjacencyList[notInstalled[j]][k];
	                        osList[p] = (osList[notInstalled[j]] == 'l') ? 'w' : 'l';
	                        visited[p] = true;
	                        notInstalled.pb(p);
	                    }
	                }
	                notInstalled.erase(notInstalled.begin()+j);
	                totalNeighboursInstalled++;
	                j--;
	            }
	            j++;
	        }
	        if(notInstalled.size() == 0) {
	            for(j = 0 ; j <numVertices ; j++) {
	                if(visited[j] == false) {
	                    notInstalled.pb(j);
	                    visited[j] = true;
	                    osList[j] = 'l';
	                    break;
	                }
	            }
	        }
	        if(findContradiction(srcList , destList , osList) == false ) {
	            ans[i] = "no";
	            contradiction = true;
	            break;
	        }
	    }
	    if(contradiction == false) {
	        ans[i] = "yes";
	    }
	}
	for(int i = 0 ; i < t ; i++) {
	    cout<<ans[i]<<endl;
	}
	return 0;
}