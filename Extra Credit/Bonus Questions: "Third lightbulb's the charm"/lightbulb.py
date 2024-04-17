class lightbulb(object):
    def fib(self, n):
        left = 0
        right = 1
        val = 0
        i = 2
        for i in range(2, n+1):
            val = left + right
            left = right
            right = val
        return val