'''
    2 <= nums.length <= 10^4
    -10^9 <= nums[i] <= 10^9
    -10^9 <= target <= 10^9
'''

nums = list(map(int, input().split()))
target = int(input())

memo = {}
def makeDict(nums):
    for i in range(len(nums)):
        memo[nums[i]] = i


def twoSum(memo, nums, target):
    for i in range(len(nums)):
        if (target - nums[i]) in memo and memo[target - nums[i]] != i:
            return [i, memo[target - nums[i]]]
    return [0,0] 

makeDict(nums)
print(twoSum(memo, nums,target))

