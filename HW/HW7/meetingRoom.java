package HW.HW7;
import java.util.*;

public class meetingRoom {

    public static int minMeetingRooms(int[][] intervals) {  // Your code here    
    List<Integer> startList = new ArrayList<>();
    List<Integer> endList = new ArrayList<>();
    for ( int [] i: intervals)
    {
        startList.add(i[0]);
        endList.add(i[1]);
    } 
    Collections.sort(startList);
    Collections.sort(endList);
    int start = 0,  end = 0, count = 0, max = 0;
    while (start < startList.size())
    {
        if (startList.get(start) < endList.get(end))
        {
            count++;
            start++;
            if (count > max)
            {
                max = count;
            }
        }
        else
        {
            count--;
            end++;
        }
        
    }
    return max;
    }

    public static void main (String [] args)
    {
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        int [][] interval1 = {};
        int result = minMeetingRooms(intervals);
        System.out.println(result);
        System.out.println(minMeetingRooms(interval1));
        int[][] completelyOverlapping = {{10, 20}, {10, 20}, {10, 20}};
        System.out.println(minMeetingRooms(completelyOverlapping));

    }

}
