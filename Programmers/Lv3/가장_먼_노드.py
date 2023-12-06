"""
1. 최단 거리 구하기 위한 다익스트라 구현
2. 모든 가중치 1로 가정하고 양방향 그래프 생성
3. 1번 노드 기준 모든 노드 거리 구하기
"""

import heapq
from collections import deque

def solution(n, edge):
    answer = 0
    
    INF = int(1e9)
    graph = [[] for i in range(n + 1)]
    distance = [INF] * (n + 1)
    
    # 양방향 그래프 생성
    for n, e in edge:
        graph[n].append((e, 1))
        graph[e].append((n, 1))
        
        
    def dijkstra(start):
        q = []
        heapq.heappush(q, (0, start))
        distance[start] = 0
        while q: # 큐가 비어있지 않다면
            # 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
            dist, now = heapq.heappop(q)
            # 현재 노드가 이미 처리된 적이 있는 노드라면 무시
            if distance[now] < dist:
                continue
            for i in graph[now]:
                cost = dist + i[1]
                # 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
                if cost < distance[i[0]]:
                    distance[i[0]] = cost
                    heapq.heappush(q, (cost, i[0]))
    
    # bfs                
    def bfs(start):
        q = deque([start])
        distance[start] = 0
        
        while q:
            now = q.popleft()
            for i in graph[now]:
                if distance[i[0]] != INF:
                    continue
                q.append(i[0])
                distance[i[0]] = distance[now] + 1
                
    # dijkstra(1)
    # 올바른 최대값 개수 추출 위한 INF 모두 0으로 변경
    # distance = [0 if x == INF else x for x in distance]
    # return distance.count(max(distance))
    
    bfs(1)
    distance = [0 if x == INF else x for x in distance]
    return distance.count(max(distance))
    
n = 6
vertex = [[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]
solution(n, vertex)