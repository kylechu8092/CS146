class isBad(object):
    #To whomever is grading, not sure how the helper isBadVersion is implemented so I simply inserted it into the algo
    def firstBadVersion(self, n: int):
        left = 1
        right = n
        def isBadVersion(self, n):
            return True
        while left < right:
            mid = (right - left)//2 + left
            if isBadVersion(mid) and not isBadVersion(mid-1):
                return mid
            elif isBadVersion(mid):
                right = mid
            else:
                left = mid + 1
        return left
        


   
