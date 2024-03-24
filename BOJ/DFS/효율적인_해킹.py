import sys
from collections import deque
input = sys.stdin.readline
N, M = map(int, input().strip().split())
graph = [[] for _ in range(N)]

for _ in range(M):
    A, B = map(int, input().strip().split())
    # 효울적인 메모리 사용
    graph[B-1].append(A-1)
    
def bfs(start):
    # 방문 처리
    visited = [False] * N
    # 방문한 컴퓨터 카운트
    cnt = 1    
    visited[start] = True
    q = deque([start])
    
    while q:
        now = q.popleft()
        for next in graph[now]:
            # 이미 방문한 컴퓨터는 넘어감
            if visited[next]: continue
            visited[next] = True
            q.append(next)
            cnt+=1 
    return cnt
    
            
# 가장 많이 해킹한 컴퓨터의 수 저장
max_cnt = -sys.maxsize
# 가장 많이 해킹한 컴퓨터 저장
result = []
for i in range(N):
    cnt = bfs(i)
    if cnt > max_cnt:
        max_cnt = cnt
        # 가장 많이 해킹한 컴퓨터의 수 갱신시 리스트 초기화
        result = [i+1]
    elif cnt == max_cnt:
        result.append(i+1)

print(*result)
    
    