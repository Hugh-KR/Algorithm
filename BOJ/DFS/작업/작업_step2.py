
import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

"""
* 방향 그래프
오늘 반드시 끝낼 작업 X를 마무리 하기 위해 먼저 해야하는 작업의 개수
"""

# 작업할 개수와 작업 순서 정보의 개수 입력
n, m = map(int, input().split())

# 그래프 생성
graph = [[ ] for _ in range(n+1)]
# 방문 처리 리스트 생성
visited = [False] * (n+1)

for _ in range(m):
    # 작업 순서 입력
    # b를 하기 위해 a를 선행해야 함
    a, b = map(int, input().split())
    # 반드시 끝낼 작업으로 부터 탐색하기위해 반대로 저장 
    graph[b].append(a)
    
# 오늘 반드시 끝낼 작업 입력
x = int(input())

count = 0
def dfs(start):
    # 글로벌 변수 선언
    global count
    visited[start] = True
    for i in graph[start]:
        if not visited[i]:
            count+=1
            dfs(i)
    
dfs(x)
print(count)