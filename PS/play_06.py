nums = set([0,3,7,2,5,8,4,6,0,1])
nums = list(nums)
nums.sort()


def pro(nums):
    if len(nums) == 0:
        return 0
    
    cnt = 1
    result = 0
    for i in range(0, len(nums)-1):
        if nums[i]+1 == nums[i+1]:
            cnt+=1
        else:
            result = max(result, cnt)
            cnt = 1

    result = max(result, cnt)
    return result



print(pro(nums))