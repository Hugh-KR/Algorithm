# 전역으로 카운트 선언
count = 0

# index = 깊이
# result = 타겟 넘버를 만들기 위해 더하고 빼는 leaf값
def dfs(numbers, index, result, target):
    global count
    
    # 모든 노드를 탐색하고 타겟 넘버를 달성했다면
    if index == len(numbers) and result == target:
        count+=1
        return
    # 모든 노드를 탐색했는데 result가 타겟 넘버와 다르다면 
    elif index == len(numbers):
        return
    
    # "-" 하는 경우와 "+" 하는 경우 재귀로 돌림
    dfs(numbers, index+1, result+numbers[index], target)
    dfs(numbers, index+1, result-numbers[index], target)

    
def solution(numbers, target):
    dfs(numbers, 0, 0, target)
    return count