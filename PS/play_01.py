# 완전탐색

def twoSumBruteForce(nums, target):
    n = len(nums)
    for i in range(n-1):
        for j in range(i+1,n):
            if nums[i] + nums[j] == target:
                return True
    return False

def twoSumTwoPointer(nums, target):
    nums.sort()
    l,r = 0,len(nums)-1

    while l < r:
        if nums[l] + nums[r] > target:
            r-=1
        elif nums[l] + nums[r] < target:
            l+=1
        elif nums[l] + nums[r] == target:
            return True
    
    return False


print(twoSumBruteForce(nums=[2,1,5,7], target=4))
print(twoSumTwoPointer(nums=[2,1,5,7], target=4))