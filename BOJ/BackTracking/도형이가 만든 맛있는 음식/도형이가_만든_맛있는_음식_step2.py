"""
1. 신맛은 사용한 재료의 신맛의 곱, 쓴맛은 합이다.
2. 재료는 적어도 하나 사용해야 한다.
3. 재료의 신맛과 쓴맛이 주어졌을 때, 신맛과 쓴맛의 차이가 가장 작은 요리를 만드는 프로그램을 작성.
"""

import sys

input = sys.stdin.readline

n = int(input())
foods = [list(map(int, input().split())) for _ in range(n)]

# 가장 최솟값을 구하기위한 최대 int
result = int(1e9)

# s = 신맛
# b = 쓴맛

# 같은 범위 탐색하지 않기 위해 start+1
def back(start, visited, s, b):
    global result
    
    if b > 0:
        # 신맛과 쓴맛 차이의 절댓값
        result = min(result, abs(s-b))
    
    for i in range(start, n):
        if not visited[i]:
            visited[i] = True
            # 신맛은 곱, 쓴맛은 합
            back(start + 1, visited, s * foods[i][0], b + foods[i][1])
            # 겹치지 않게 모든 경우 탐색하기위해 방문처리해제
            visited[i] = False
            
visited = [False] * n
back(0,visited,1,0)
print(result)