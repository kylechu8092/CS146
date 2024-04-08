package ExtraCredit.EverythingEverywhere;
import java.util.*;

public class graph {

    public int [][] convertAdjMatrix(List<List<Integer>> adjList)
    {
        int max = adjList.size(); //Gives us the size of our matrix
        int[][] matrix = new int[max][max]; //Create our matrix
        for (int i = 0; i < max; i++) //Loop through all lists
        {
            for (Integer val: adjList.get(i)) //Retrieve the integer values from the sublists
            {
                matrix[i][val] = 1;
            }
        }
        return matrix;
    }

    public List<List<Integer>> adjList(int [][] adjMatrix)
    {
        List<List<Integer>> adjList = new ArrayList<List<Integer>>();//Initalize list
        for (int i = 0; i < adjMatrix[0].length; i++)
        {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < adjMatrix[i].length; j++)
            {
                //Checks if 1 is in matrix
                if (adjMatrix[i][j] == 1)
                {
                    temp.add(j);
                }
            }
            adjList.add(temp);
        }
        return adjList;
    }

    public List<List<Integer>> reverseGraph(List<List<Integer>> adjList)
    {
        List<List<Integer>> newList = new ArrayList<List<Integer>>(); //Initalize new graph based on size of adjList 
        for (int i = 0; i < adjList.size(); i++) //fill the new graph
        {
            newList.add(new ArrayList<>())
        }
        for (int i = 0; i < adjList.size(); i++) //Iterate through the sublists
        {
            for (int j = 0; j < adjList.get(i).size(); i++) //iterate through val in sublist
            {
            	int val = adjList.get(j).get(i); //retrieve the value in adjList
                newList.get(val).add(i);
            }
        }
        return newList;
    }


}
