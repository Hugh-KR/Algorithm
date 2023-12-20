"""
부모 자식간의 관계를 나타내는 두 번호 x,y 주어짐,
이때 앞에 나오는 번호 x는 뒤에 나오는 정수 y의 부모 번호를 나타냄

-> 입력에서 요구한 두 사람의 촌수를 나타내는 정수를 출력
-> 친척 관계가 없는 경우 -1 출력
"""

import sys
input = sys.stdin.readline
# 재귀 깊이 설정
sys.setrecursionlimit(10**6)

# 전체 사람 수 입력
n = int(input())
# 촌수를 비교해야 하는 두 사람 입력
a, b = map(int, input().split())
# 부모 자식간 관계의 개수 입력
m = int(input())

# 그래프 생성
graph = [[ ] for _ in range(n+1)]
# 방문 처리 리스트 생성
visited = [False] * (n+1)
for _ in range(m):
    # x는 부모, y는 자식
    x, y = map(int, input().split())
    # 둘 중 어느곳에서 출발해도 가족이 성립해야함 -> 양방향 그래프 구성
    graph[x].append(y)
    graph[y].append(x)

result = -1
count = 0
def dfs(start):
    global result, count
    # b와 가족인 경우
    if start == b:
        # 결과 변수에 저장
        result = count
        return
    # 현재 위치 방문 처리
    visited[start] = True
    for i in graph[start]:
        if visited[i]: continue
        count+=1
        dfs(i)
        # 양방향 그래프, 한번 방문했다면 정확한 탐색을 위해 돌아가야함
        count-=1

dfs(a)
print(result)