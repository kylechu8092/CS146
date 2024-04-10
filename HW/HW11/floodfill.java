package HW.HW11;

public class floodfill {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // Your code here
        if (image[sr][sc] == color) //if done
        {
            return image;
        }
        fill(image,sr,sc,color,image[sr][sc]);
        return image;
     }
     
     public static void fill(int [][]image, int sr, int sc, int color, int startColor)
     {
        //Edge cases we stop calls if the sr and sc are out of bounds and if the curr val of the color doesn't match
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || startColor != image[sr][sc])
        {
            return;
        }
        //Call on all directions, essentially dfs in all directions
        image[sr][sc] = color;
        fill(image, sr-1,sc,color,startColor); //down 
        fill(image, sr+1,sc,color,startColor); //up 
        fill(image, sr,sc-1,color,startColor); //left 
        fill(image, sr,sc+1,color,startColor); //right 


     }
}
