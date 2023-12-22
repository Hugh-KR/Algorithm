"""
단맛을 사용하는 경우와 쓴 맛을 사용하는 경우
"""

import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

n = int(input())

foods = [list(map(int, input().split())) for _ in range(n)]
# 음식 방문 처리
visited = [False] * n

# 가장 작은 결과 구하기위한 최대 int
result = int(1e9)

def back(visited, s, b):
    global result
    if b > 0:
        result = min(result, abs(s-b))
        
    for i in range(0, n):
        # 아직 방문하지 않은 음식이라면
        if not visited[i]:
            # 방문 처리
            visited[i] = True
            # s = 신맛, b = 단맛
            back(visited, s * foods[i][0], b + foods[i][1])
            visited[i] = False
            
back(visited, 1, 0)
print(result)