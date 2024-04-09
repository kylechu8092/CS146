class validAnagram(object)
    def isAnagram(self, s, t):
        return self.counter(s) == self.counter(t)
        
    def counter(self, s):
        count = {}
        for c in s:
            if c in count:
                count[c] +=1
            else:
                count[c] = 1
        return count
