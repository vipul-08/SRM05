#include <stdio.h>
int main() {
	int t;
	int numSystems, availableRepeaters, availableWires;
	int distance;
	scanf("%d",&t);
	while(t--) {
	    scanf("%d %d %d",&numSystems,&availableRepeaters,&availableWires);
	    for(int j = 0 ; j < numSystems-1 ; j++ ) {
	        scanf("%d",&distance);
	        if(distance > 150) {
	            availableRepeaters--;
	        }
	        availableWires -= distance;
	    }
	    if(availableWires < 0 || availableRepeaters < 0) {
	        printf("insufficient\n");
	    }
	    else {
	        printf("sufficient\n");
	    }
	}
	return 0;
}