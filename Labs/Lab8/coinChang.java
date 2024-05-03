package Lab.Lab8;

public class coinChang {
    public int coinChange(int[] coins, int amount) 
    {
        int [] leastCoin = new int [amount+1];
        leastCoin[0] = 0;
        for (int i = 1; i < leastCoin.length; i++)
        {
            //Iterate through every possible value of amount and store least coin at index i
            leastCoin[i] = amount+1;
            //Now iterate through every coin
            for (Integer coin: coins)
            {
                if (i >= coin)
                {
                    leastCoin[i] = Math.min(leastCoin[i], leastCoin[i-coin] + 1);
                }
            }
        
        }
        if (leastCoin[amount] == amount+1)
            {
                return -1;
            }
            else
        {
                return leastCoin[amount];
        }
    }
}
