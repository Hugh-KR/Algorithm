"""
사다리를 이용해 이동한 칸의 번호는 원래 있던 칸의 번호보다 크다
뱀을 이용해 이동한 칸의 번호는 원래 있던 칸의 번호보다 작아진다
"""
import sys
from collections import deque

input = sys.stdin.readline
n, m = map(int, input().split())

graph = [i for i in range(101)]

for _ in range(n+m):
    a, b = map(int, input().split())
    graph[a] = b

print(graph)
visited = [0] * 101

def bfs(start):
    q = deque([start])
    visited[start] = 1
    
    while q:
        target = q.popleft()
        
        for i in range(1, 7):
            