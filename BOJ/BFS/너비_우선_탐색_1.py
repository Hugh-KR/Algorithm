"""
1. N개의 정점과 M개의 간선으로 구성된 무방향 그래프가 주어짐
2. 1번 부터 N번까지 모든 가중치는 1
3. 정점 R에서 시작해서 너비 우선 탐색으로 노드를 방문할 경우 노드의 방문 순서 출력

* 인접 정점은 오름차순으로 방문
"""
import sys
import heapq
from collections import deque
input = sys.stdin.readline

# 정점의 수, 간선의 수, 시작 정점
n, m, r = map(int, input().split())
# 그래프 생성
graph = [[] for _ in range(n+1)]


# 힙큐 - 실패.. 왜지?
for _ in range(m):
    # 정점 u와 정점 v의 가중치 1인 양방향 간선
    u, v = map(int, input().split())
    heapq.heappush(graph[u], v)
    heapq.heappush(graph[v], u)


# 리스트
# for _ in range(m):
#     # 정점 u와 정점 v의 가중치 1인 양방향 간선
#     u, v = map(int, input().split())
#     graph[u].append(v)
#     graph[v].append(u)

def bfs(graph, start):
    # 방문 처리용 리스트 
    visited = [0] * (n+1)
    # 거리 저장용 변수
    count = 1
    # 디큐 생성 
    q = deque()
    q.append(start)
    # 현재 정점 방문 처리용 거리 입력
    visited[start] = count
    # 큐에 남은 값이 있다면
    while q:
        # 현재 정점
        current = q.popleft()
        print(graph[current])
        graph[current].sort()
        print(graph[current])
        for cur in graph[current]:
            # 이미 방문 했다면
            if visited[cur] > 0: continue
            # 거리 확장하고 저장
            count+=1
            visited[cur] = count
            # 다음 탐색 위해 큐에 저장
            q.append(cur)
    return visited   


for node in bfs(graph, r)[1:]:
    print(node)