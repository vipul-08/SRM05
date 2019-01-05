t = int(input())
for i in range(0,t):
    temp = input().split(" ")
    numSystems = int(temp[0])
    availableRepeaters = int(temp[1])
    availableWires = int(temp[2])
    dist = input().split(" ")
    for j in range(0,numSystems-1):
        distance = int(dist[j])
        if(distance>150):
            availableRepeaters -= 1
        availableWires -= distance
    if(availableWires < 0 or availableRepeaters < 0):
        print("insufficient")
    else:
        print("sufficient")