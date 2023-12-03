"""
1. 다익스트라 알고리즘 구현 -> O
2. fares 사용하여 그래프 만들기 -> O
3. 각자 이동하는 경우 최저 택시요금 구하기 -> O
4. 모든 노드를 중간지점으로 가정하고 s,a,b 까지의 합 구하기 -> O
5. s,a,b 까지의 합 구하며 최솟값 갱신하기 -> O
"""

import heapq

def solution(n, s, a, b, fares):
    answer = 0
    
    INF = int(1e9)
    graph = [[] for i in range(n + 1)]
    distance_a = [INF] * (n + 1)
    
    for start, end, cost in fares:
        graph[start].append((end, cost))
        graph[end].append((start, cost))
    
    def dijkstra(start):
        q = []
        distance = distance_a.copy()
        heapq.heappush(q, (0, start))
        distance[start] = 0
        while q:
            dist, now = heapq.heappop(q)
            if distance[now] < dist:
                continue
            for i in graph[now]:
                cost = dist + i[1]
                if cost < distance[i[0]]:
                    distance[i[0]] = cost
                    heapq.heappush(q, (cost, i[0]))
        return distance
        
    min_distance = INF
    for i in range(1, n + 1):
        start_i = dijkstra(i)
        min_distance = min(min_distance, start_i[s] + start_i[a] + start_i[b])
    
    return min_distance