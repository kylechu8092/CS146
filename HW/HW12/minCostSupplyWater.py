class UnionFind:
    def __init__(self,size):
        self.parent = list(range(size))
        self.rank = [0] * size

    def find(self, p):
        #Path compression
        if self.parent[p] != p:
            se
            lf.parent[p] = self.find(self.parent[p]) 
        return self.parent[p]

    def unify(self, p, q):
        rootP = self.find(p)
        rootQ = self.find(q)
        if rootP != rootQ: #Lets unify by rank
            if self.rank[rootP] > self.rank[rootQ]:
                self.parent[rootQ] = rootP
            elif self.rank[rootP] < self.rank[rootQ]:
                self.parent[rootP] = rootQ
            else:
                self.parent[rootQ] = rootP
                self.rank[rootP] += 1

class Edge:
    def __init__(self, src, dest, cost):
        self.cost = cost
        self.src = src
        self.dest = dest

    #compareTo in python
    def __lt__(self, object):
        return self.cost < object.cost



def minCostToSupplyWater(n: int, wells, pipes) -> int:
    edgeList = []
    for i in range(1, n+1):
        edgeList.append(Edge(0,i, wells[i-1]))
    for pipe in pipes:
        edgeList.append(Edge(pipe[0], pipe[1], pipe[2]))

    edgeList.sort()
    uf = UnionFind(n+1)

    cost = 0
    for edge in edgeList:
        rootSrc = uf.find(edge.src)
        rootDest = uf.find(edge.dest)
        if (rootSrc == rootDest):
            continue
        uf.unify(rootSrc, rootDest)
        cost += edge.cost
        n -=1
        if n==0:
            break

    return cost

n1 = 3
wells1 = [1, 2, 3]
pipes1 = []
print(minCostToSupplyWater(n1, wells1, pipes1))

n2 = 1
wells2 = [10]
pipes2 = []
print(minCostToSupplyWater(n2, wells2, pipes2))