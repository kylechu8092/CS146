package HW.HW12;


import java.util.*;

public class minCostSupplyWater {

    public static class Edge implements Comparable<Edge>
    {
        int src;
        int dest; 
        int weight;
        public Edge(int src, int dest, int weight)
        {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o)
        {
            return this.weight - o.weight;
        }
    }

    public static class UnionFind
    {
        int[] parent;
        int[] size;

        public UnionFind(int n)
        {
            //Set every node as each other parent
            parent = new int [n + 1];
            for (int i = 1; i < parent.length; i++)
            {
                parent[i] = i;
            }
            size = new int[n+1];
        }

        public int find(int n)
        {
            //Finds the root of n
            int root = n;
            while (root != parent[root])
            {
                root = parent[root];
            }
            //Compress the path to root, essentially
            //points all nodes in the path from n to root
            //to the root, which compresses the nodes
            while (n != root)
            {
                int currNext = parent[n];
                parent[n] = root;
                n = currNext;
            }
            return root;
        }

        public void unify(int x, int y)
        {
            int rootx = find(x);
            int rooty = find(y);
            //Already in the same set
            if (rootx == rooty)
            {
                return;
            }
            if (size[rootx] > size[rooty])
            {
                //We add size and change the pointers of parent of smaller  size
                size[rootx] += size[rooty];
                parent[rooty] = x;
            }
            else
            {
                size[rooty] += size[rootx];
                parent[rootx] = y;
            }
        }

    }
    
    public static int minCostToSupplyWater(int n, int[] wells, int[][] pipes) 
    {
        // Your code here
        List<Edge> edgeList = new ArrayList<>();
        //Think of a well as a singular node, connect all nodes to that singular node with a weight
        for (int i = 1; i <= wells.length; i++)
        {
            edgeList.add(new Edge(0, i, wells[i-1]));
        }

        //Add the weights of all pipes
        for (int [] pipe: pipes)
        {
            edgeList.add(new Edge(pipe[0],pipe[1], pipe[2]));
        }

        //Sort the weights
        Collections.sort(edgeList);
        UnionFind union = new UnionFind(n);
        int total = 0;
        for (Edge edge: edgeList)
        {
            int root1 = union.find(edge.src);
            int root2 = union.find(edge.dest);
            if (root1 == root2)
            {
                //They are already connected
                continue;
            }
            //Aren't connected we unify them toghether
            total += edge.weight;
            union.unify(root1, root2);
            //Important to update the number of houses because 
            //there can be multiple edges pointing to one house, so we can cut loop short if we found the best path
            n--;
            if (n == 0)
            {
                return total;
            }
        }
        return total;
     }

     public static void main(String [] args)
     {
        int n1 = 3;
        int[] wells1 = {1, 2, 3};
        int[][] pipes1 = {};
        System.out.println(minCostToSupplyWater(n1, wells1, pipes1));  // Test Case 1 = 6
        int n2 = 1;
        int[] wells2 = {10};
        int[][] pipes2 = {};
        System.out.println(minCostToSupplyWater(n2, wells2, pipes2));  // Test Case 2 = 10
     }
}
