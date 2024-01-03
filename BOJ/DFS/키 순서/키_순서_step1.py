"""
방향 그래프
"""
import sys
input = sys.stdin.readline

n,m = map(int, input().split())

graph = [[ ] for _ in range(n+1)]
reversed_graph = [[ ] for _ in range(n+1)]


for _ in range(m):
    a,b = map(int, input().split())
    # a -> b
    graph[a].append(b)
    reversed_graph[b].append(a)
    

count = 0
def dfs(start, visited, graph):
    global count
    visited[start] = True
    for cur in graph[start]:
        if visited[cur]: continue
        visited[cur] = True
        count += 1
        dfs(cur, visited, graph)


# 자신의 키가 몇 번째 인지 알 수 있는 학생의 수를 저장하는 변수
result = 0
for i in range(1, n+1):
    count = 0
    visited = [False] * (n+1)
    dfs(i, visited, graph)
    visited = [False] * (n+1)
    dfs(i, visited, reversed_graph)
    if count == n-1:
        result+=1
    

 
print(result)