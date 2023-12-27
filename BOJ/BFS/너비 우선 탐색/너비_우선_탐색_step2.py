"""
1. 무방향 그래프 만들기
2. 인접 정점은 오름차순으로 방문
"""

import sys
from collections import deque

input = sys.stdin.readline

n,m,r = map(int, input().split())

# graph
graph=[[] for _ in range(n+1)]
# 방문 리스트
visited=[0]*(n+1) 

# 입력 받는 간선 정보 그래프화
for i in range(m):
    u,v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)
    
# 정렬
for i in range(n+1):
    graph[i].sort()
    
# BFS 함수    
def bfs(start):
   
    q = deque()
    q.append(start)
    # 첫번째 방문 지점
    num = 1
    visited[start]=num
    
    while q:
        cur=q.popleft()
        
        for i in graph[cur]:
            # 이미 방문 했다면
            if visited[i]: continue
            # 아니라면 거리 확장하고 저장
            num+=1
            visited[i]=num
            q.append(i)

bfs(r)
for i in visited[1:]:
    print(i)
    
    