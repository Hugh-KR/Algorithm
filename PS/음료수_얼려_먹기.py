import sys
input = sys.stdin.readline

N, M = map(int, input().split())
adj = [list(map(int, input().strip())) for _ in range(N)]

# DFS로 특정 노드를 방문하고, 연결된 모든 노드들도 방문
def dfs(y, x):
    # 주어진 범위를 벗어나는 경우 즉시 종료
    if y <= -1 or y >= N or x <= -1 or x >= M:
        return False
    # 현재 노드를 아직 방문하지 않았다면
    if not adj[y][x]:
        # 해당 노드 방문처리
        adj[y][x] = 1
        # 상, 좌, 하, 우 위치들도 모두 재귀적 호출
        dfs(y-1, x)
        dfs(y, x-1)
        dfs(y+1, x)
        dfs(y, x+1)
        return True
    # 현재 노드를 이미 방문 했다면
    return False
    
result = 0
for y in range(N):
    for x in range(M):
        if dfs(y, x):
            result += 1
        
        
print(result)
