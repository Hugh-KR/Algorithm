import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())
# sys의 개행 문자 제거
adj = [list(map(int, input().strip())) for _ in range(N)]
check = [[False] * M for _ in range(N)]

dy = [-1, 0, 1, 0]
dx = [0, -1, 0, 1]


def isValid(ny, nx):
    return 0 <= ny < N and 0 <= nx < M 

def bfs(y, x):
    q = deque()
    
    # 마지막에 현재 거리 정보 추가
    q.append((y, x, 1))
    # 방문하지 않았을 경우 방문 처리
    check[y][x] = True
    
    while q:
        now_y, now_x, now_d = q.popleft()
        
        # 인접 행렬의 끝에 도달했을 경우 위치 정보 반환
        if now_y == N-1 and now_x == M-1: return now_d
        # 아직 끝이 아닐 경우 위치 1 증가
        nd = now_d + 1
        
        for i in range(4):
            ny = now_y + dy[i]
            nx = now_x + dx[i]

            # 벗어난 범위일 경우 넘어거기
            # 방문한 위치인지 검증
            if isValid(ny, nx) and adj[ny][nx] and not check[ny][nx]:
                check[ny][nx] = True
                q.append((ny, nx, nd))


print(bfs(0, 0))
