import time

# 정렬 풀이 O(nlogn)
# def pro(nums): 
#     if len(nums) == 0:
#         return 0
    
#     cnt = 1
#     result = 0
#     for i in range(0, len(nums)-1):
#         if nums[i]+1 == nums[i+1]:
#             cnt+=1
#         else:
#             result = max(result, cnt)
#             cnt = 16

#     result = max(result, cnt)
#     return result


nums = [0,3,7,2,5,8,4,6,0,1]

# set 풀이
def longestConsecutive(nums):
    if len(nums) == 0:
        return 0
    
    longest_streak = 0
    num_set = set(nums)

    for n in num_set:
        if n-1 not in num_set:
            current_num = n
            current_streak = 1

            while current_num + 1 in num_set:
                current_num += 1
                current_streak += 1
            
            longest_streak = max(longest_streak, current_streak)

    return longest_streak


start_time = time.time()

print(longestConsecutive(nums))

end_time = time.time()

print("time:", end_time - start_time);