import sys
from collections import deque

input = sys.stdin.readline
N, M = map(int, input().split())

adj = []
for i in range(N):
    # sys의 개행 문자 제거
    adj.append(list(map(int, input().strip())))

check = [[False] * M for _ in range(N)]


def isValid(ny, nx):
    return ny < N and ny >= 0 and nx < M and nx >= 0


dy = [-1, 0, 1, 0]
dx = [0, -1, 0, 1]


def bfs(y, x):
    q = deque()
    q.append((y, x))
    while q:
        now_y, now_x = q.popleft()
        # 방문한 위치일 경우 넘어가기
        if check[now_y][now_x]: continue
        # 방문하지 않았을 경우 방문 처리
        check[now_y][now_x] = True
        
        for i in range(4):
            ny = now_y + dy[i]
            nx = now_x + dx[i]

            # 벗어난 범위일 경우 넘어거기
            if not isValid(ny, nx): continue
            # 방문한 위치인지 이중 검증
            if check[ny][nx]: continue
            
            if adj[ny][nx]:
                # 다음 방문할 위치에 1 추가
                adj[ny][nx] = adj[now_y][now_x] + 1
                q.append((ny, nx))


bfs(0, 0)

# for j in adj:
#     print(j)

print(adj[N - 1][M - 1])
