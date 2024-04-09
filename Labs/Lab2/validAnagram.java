import java.util.*;

public class validAnagram
{
    public boolean isAnagram(String s, String t) 
    {
        HashMap<Character, Integer> sCount = counter(s);
        HashMap<Character, Integer> tCount = counter(t);
        return sCount.equals(tCount);
    }
    
    public static HashMap<Character, Integer> counter(String s) {
        HashMap<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
        {
            if (count.containsKey(s.charAt(i)))
            {
                count.put(s.charAt(i), count.get(s.charAt(i)) + 1);
            }
            else
            {
                count.put(s.charAt(i), 1);
            }
        }
        return count;
    }
}



