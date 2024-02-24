import sys
sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline

N, M = map(int, input().split())
adj = [[0] * N for _ in range(N)]
chk = [False] * (N)

for _ in range(M):
    y, x = map(lambda a : a - 1, map(int, input().split()))
    adj[y][x] = adj[x][y] = 1

def dfs(now):
    
    for nxt in range(N):
        # 방문 가능한 위치이고 아직 방문하지 않았다면
        if adj[now][nxt] and not chk[nxt]:
            chk[nxt] = True
            dfs(nxt)


# 연결 요소 개수
count = 0
for now in range(N):
    if not chk[now]:
        # 탐색 끝나면 연결 요소 개수 += 1
        count += 1
        chk[now] = True
        dfs(now)     
        
print(count)

        
        