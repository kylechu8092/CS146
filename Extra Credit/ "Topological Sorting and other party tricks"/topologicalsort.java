package ExtraCredit.TopologicalSort;
import java.util.*;

public class topologicalsort {

    public static List<Integer> kahn(List<List<Integer>> adjList, int numVert)
    {
        //First task, figure out the number of indegrees in every node
        int [] numIndegree = new int [numVert];
        for (List<Integer> sublist: adjList)
        {
            for (Integer vertices: sublist)
            {   
                numIndegree[vertices]++;
            }
        }

        //Add our 0 indegrees to queue
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> sorted = new ArrayList<>();
        for (int i = 0; i < numVert; i++)
        {
            if (numIndegree[i] == 0)
            {
                q.add(i);
            }
        }

        //Do sort
        while (!q.isEmpty())
        {
            int curr = q.poll();
            sorted.add(curr);
            //Handle adjacent 
            for (Integer adj: adjList.get(curr))
            {
                numIndegree[adj]--;
                if (numIndegree[adj] == 0)
                {
                    q.add(adj);
                }
            }
        }
        return sorted;
    }

    public static List<Integer> dfsTopological(List<List<Integer>> adjList, int numVert)
    {
        //Find the nodes with no outgoing indegrees and add them to our stack first, 
        //then add the nodes that have no indegrees into stack
        Stack<Integer> stk = new Stack<>();
        boolean [] visited = new boolean [numVert];
        ArrayList<Integer> sorted = new ArrayList<>();
        
        //Now we can perform dfs once we have our stack setup
        for (int i = 0; i < adjList.size(); i++)
        {
            if (visited[i] == false)
            {
                helperDFS(i, adjList, numVert, stk, visited);
            }
        }
        while (!stk.isEmpty())
        {
            int curr = stk.pop();
            sorted.add(curr);
        }
        return sorted;
    }

    public static void helperDFS(int current, List<List<Integer>> adjList, int numVert, Stack<Integer> stk, boolean [] visited)
    {
         //Visit the current node
        visited[current] = true;
        for (Integer neighbor: adjList.get(current))
        {
            if (visited[neighbor] != true)
            {
                helperDFS(neighbor, adjList, numVert, stk, visited);
            }
        }
        stk.push(current);
    }

    //Confused as to how to implement, Kahn used bfs too
    public static List<Integer> bfsTopological(List<List<Integer>> adjList, int numVert)
    {
        Queue<Integer> q = new LinkedList<>();
        boolean [] visited = new boolean [numVert];
        ArrayList<Integer> sorted = new ArrayList<>();

        //Follow kahn similar
        int [] numIndegree = new int [numVert];
        for (List<Integer> sublist: adjList)
        {
            for (Integer vertices: sublist)
            {   
                numIndegree[vertices]++;
            }
        }

        //Add 0 indegrees
        for (int i = 0; i < numVert; i++)
        {
            if (numIndegree[i] == 0)
            {
                visited[i] = true;
                q.add(i);
            }
        }

        //Since a queue is in the first in and first out
        //We will add the list of nodes that have no outgoing indegrees because we are unable to reach them in traversal
        while (!q.isEmpty())
        {
            int curr = q.poll();
            sorted.add(curr);
            for (Integer neighbor: adjList.get(curr))
            {
                if (visited[neighbor] == false)
                {
                    visited[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }

        return sorted;
        }
        


    //SUCCESSSSSSSSSSSSS
    public static void test()
    {
        List<List<Integer>> test1 = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            test1.add(new ArrayList<>()); 
        }
        test1.get(0).add(2);
        test1.get(1).add(2);
        test1.get(2).add(3);
        test1.get(3).add(4);
        test1.get(4).add(5);
        List<Integer> sorted = kahn(test1, 6);
        System.out.println(sorted);
        List<Integer> sorted2 = dfsTopological(test1, 6);
        System.out.println(sorted2);
        List<Integer> sorted3 = bfsTopological(test1, 6);
        System.out.println(sorted3);

    }
    public static void main(String [] args)
    {
        test();
    }


}
