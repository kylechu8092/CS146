def threeSum(self, nums):
    nums = sorted(nums)
    finalList = []
    for i in range(len(nums)):
        if i > 0 and nums[i] == nums[i-1]:
            continue
        j = i + 1
        k = len(nums)-1
        while j < k:
            threeSum = nums[i] + nums[j] + nums[k]
            if threeSum == 0:
                finalList.append([nums[i],nums[j],nums[k]])
                j+=1
                while nums[j] == nums[j-1] and j < k:
                    j += 1
            elif threeSum < 0:
                j+=1
            else:
                k -= 1
    return finalList
