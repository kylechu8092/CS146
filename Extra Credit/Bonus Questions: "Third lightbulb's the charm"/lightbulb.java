package ExtraCredit.ThirdLightbulb;

public class lightbulb {
    public static int fib(int n)
    {
        if (n <= 1)
        {
            return n;
        }
        int left = 0;
        int right = 1;
        int val = 0;
        //Start at two because we already don't care 0,1,1
        for (int i = 2; i <= n; i++)
        {
            //Add two
            val = left + right;
            //Update the two pointers
            left = right;
            right = val;
        }
        return val;
    }

    public static void main (String [] args)
    {
        System.out.println(fib(1));
        System.out.println(fib(10));
    }
}
