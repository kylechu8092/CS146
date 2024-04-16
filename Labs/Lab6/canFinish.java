package Lab.Lab6;
import java.util.*;

public class canFinish {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //goal is to determine whether or not the prequisite is acyclic or cyclic
        //We can use kahns algo, but we have to create an adjList first
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer>[] adjList = new ArrayList[numCourses];
        int[] inDegree = new int [numCourses];
        List<Integer> finalList = new ArrayList<>();
        if (prerequisites.length == 0)
        {
            return true;
        }
        //Fill up arrayList
        for (int i = 0; i < numCourses; i++)
        {
            adjList[i] = new ArrayList<>();
        }
        for (int[] pairs: prerequisites)
        {
            //Add them to our adjList and update the indegrees
            int course = pairs[0];
            int prereq = pairs[1];
            adjList[prereq].add(course);
            inDegree[course]++;
        }
          

        for (int i = 0; i < numCourses; i++)
        {
            if (inDegree[i] == 0)
            {
                q.add(i);
            }
        }
        
        while (!q.isEmpty())
        {
            int curr = q.poll();
            finalList.add(curr);
            for (Integer neighbor: adjList[curr])
            {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0)
                {
                    q.add(neighbor);
                }
            }
        }
        return finalList.size() == numCourses;    
    }

    public static void main(String[] args) {
        canFinish test = new canFinish();
        int numCourses = 5;
        int[][] prerequisites = {{1,4},{2,4},{3,1},{3,2}};
        System.out.println(test.canFinish(numCourses, prerequisites));  
    }
}
