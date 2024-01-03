"""
모눈종이의 맨 가장자리에는 치즈가 놓이지 않는 것으로 가정
"""

import sys
from collections import deque

input = sys.stdin.readline
n,m = map(int, input().split())

field = []

for i in range(n):
    a = list(map(int, input().split()))
    field.append(a)

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(start_x, start_y):
    q = deque()
    q.append((start_x, start_y))
    visited[start_x][start_y] = 1
    
    while q:
        cur_x, cur_y = q.popleft()
        for i in range(4):
            nx = cur_x + dx[i]
            ny = cur_y + dy[i]
            # 범위 초과하면 건너뜀
            if nx >= n or nx < 0 or ny >= m or ny < 0: continue
            # 해당 위치가 공기일 경우 큐에 저장, 방문 처리
            if field[nx][ny] == 0 and visited[nx][ny] == 0:
                q.append((nx, ny))
                visited[nx][ny] = 1
            # 해당 위치가 치즈일 경우 방문 정보 갱신
            elif field[nx][ny] == 1:
                visited[nx][ny] += 1
            
time = 0
while True:
    visited = [[0] * m for _ in range(n)]
    bfs(0,0)
    # 탐색 끝나면 시간 += 1
    time += 1
    
    # 두 변 이상 공기에 접촉했다면 녹여 없앰
    for i in range(n):
        for j in range(m):
            if visited[i][j] >= 2:
                field[i][j] = 0
    # 공기 카운트
    air = 0 
    for i in range(n):
        for j in range(m):
            if field[i][j] == 0:
                air+=1
    
    if air == (n*m):
        break

    
print(time)

