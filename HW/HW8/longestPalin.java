package HW.HW8;

public class longestPalin {
    
    public int longestPalindrome(String s) {
        // ASCII characters
        int [] count = new int [128];
        for (char c: s.toCharArray())
        {
            count[c]++;
        }
        int result = 0;
        for (int current: count)
        {
            result += current / 2 * 2;
            if (result == 0 && current % 2 == 1)
            {
                result++;
            }
        }
        return result;

    }
}
