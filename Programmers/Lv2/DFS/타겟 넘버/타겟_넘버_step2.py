"""
'-'인 경우와 '+'인 경우
"""

count = 0

def dfs(numbers, index, result, target):
    # 글로벌 변수 선언
    global count
    # 인덱스의 깊이가 끝까지 도달한 경우
    if index == len(numbers):
        # 인덱스의 깊이가 끝까지 도달했고, 타겟 넘버에 도달한 경우
        if (result == target):
            count+=1
        return
    
    # '+'인 경우 탐색
    dfs(numbers, index+1, result+numbers[index], target)
    # '-'인 경우 탐색
    dfs(numbers, index+1, result-numbers[index], target)
    
def solution(numbers, target):
    # 방문 처리가 필요 없는 이유 - 이전에 방문한 위치도 다시 방문하여 탐색 해야 함
    # visited = [False] * len(numbers)
    dfs(numbers,0,0,target)
    return count