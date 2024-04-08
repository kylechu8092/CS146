def twoSum(self, nums: List[int], target: int) -> List[int]:
    sumMap = {}
    for i in range(len(nums)):
        complement = target - nums[i]
        if complement in sumMap:
            return [sumMap[complement], i]
        sumMap[nums[i]] = i
    return []

