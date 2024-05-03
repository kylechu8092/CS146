def coinChange(self, coins: List[int], amount: int) -> int:
        #Fill w max values
        leastCoin = [amount+1] * (amount+1)
        leastCoin[0] = 0
        for target in range(1, amount + 1):
            for coin in coins:
                if target >= coin:
                    leastCoin[target] = min(leastCoin[target], leastCoin[target-coin]+1)
        if leastCoin[amount] == amount+1:
            return -1
        else:
            return leastCoin[amount]