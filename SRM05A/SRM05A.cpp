#include <iostream>
using namespace std;
int main() {
	int t;
	cin>>t;
	while(t--) {
	    int numSystems, availableRepeaters, availableWires;
	    cin>>numSystems>>availableRepeaters>>availableWires;
	    for(int j = 0 ; j < numSystems-1 ; j++ ) {
	        int distance;
	        cin>>distance;
	        if(distance > 150) {
	            availableRepeaters--;
	        }
	        availableWires -= distance;
	    }
	    if(availableWires < 0 || availableRepeaters < 0) {
	        cout<<"insufficient\n";
	    }
	    else {
	        cout<<"sufficient\n";
	    }
	}
	return 0;
}