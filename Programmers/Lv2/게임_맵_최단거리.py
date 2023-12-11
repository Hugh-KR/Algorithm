"""
1. 미로게임 -> BFS
2. 큐를 생성하고 조건을 만족할 경우 거리를 더해가며 진행
"""

from collections import deque

# 상하좌우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(x, y, maps):
    q = deque()
    q.append((x, y))
    
    # 큐가 빌 때까지 반복
    while q:
        x, y = q.popleft()
        # 상하좌우 칸 확인하기
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            # 맵을 벗어나면 무시하기
            if is_out_of_range(nx, ny, maps):
                continue
            # 벽이면 무시하기
            if is_wall(nx, ny, maps):
                continue
            # 처음 지나가는 길이면 거리 계산하고, 다시 상하좌우 확인하기    
            if maps[nx][ny] == 1:
                maps[nx][ny] = maps[x][y] + 1
                q.append((nx, ny)) # 반복
                
    # 상대방 진영 방문하지않은 경우, -1 반환 
    if maps[-1][-1] == 1:
        return -1
    # 방문한 경우 지나가야 하는 칸의 최솟값 출력
    return maps[-1][-1]

def is_out_of_range(nx, ny, maps):
    return nx < 0 or nx >= len(maps) or ny < 0 or ny >= len(maps[0])

def is_wall(nx, ny, maps):
    return maps[nx][ny] == 0   

def solution(maps):
    result = bfs(0,0,maps)
    return result