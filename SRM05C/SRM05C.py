# Contradiction Finder Function
def findContradiction(sList,dList,oList):
    for i in range(0,len(sList)):
        if oList[sList[i]] == 'n' or oList[dList[i]] == 'n':
            continue
        elif oList[sList[i]] == oList[dList[i]]:
            return False
    return True
# Main Code
t = int(input())
ans = []
for i in range(0,t):
    ans.append("no")
    vars = input().split(" ")
    numVertices = int(vars[0])
    numConnections = int(vars[1])
    srcList = []
    destList = []
    totalNeighboursInstalled = 0
    adjacencyList = {}
    osList = []
    visited = []
    for j in range(0,numVertices):
        osList.append('n')
        adjacencyList[j] = []
        visited.append(False)
    for j in range(0,numConnections):
        vars = input().split(" ")
        src = int(vars[0])
        dest = int(vars[1])
        adjacencyList[src-1].append(dest-1)
        adjacencyList[dest-1].append(src-1)
        srcList.append(src-1)
        destList.append(dest-1)
    
    osList[0] = 'l'
    contradiction = False
    visited[0] = True
    
    notInstalled = []
    notInstalled.append(0)
    
    while totalNeighboursInstalled < numVertices:
        j = 0
        while j < len(notInstalled):
            if visited[notInstalled[j]] == True:
                for k in range(0,len(adjacencyList[notInstalled[j]])):
                    if visited[adjacencyList[notInstalled[j]][k]] == False:
                        p = adjacencyList[notInstalled[j]][k]
                        if osList[notInstalled[j]] == 'l':
                            osList[p] = 'w'
                        else:
                            osList[p] = 'l'
                        visited[p] = True
                        notInstalled.append(p)
                
                notInstalled.remove(notInstalled[j])
                totalNeighboursInstalled += 1
                j -= 1
            j += 1
        if len(notInstalled) == 0:
            for j in range(0,numVertices):
                if visited[j] == False:
                    notInstalled.append(j)
                    visited[j] = True;
                    osList[j] = 'l'
                    break
        if findContradiction(srcList , destList , osList) == False:
            ans[i] = "no"
            contradiction = True
            break
    if contradiction == False:
        ans[i] = "yes"
for i in ans:
    print(i)