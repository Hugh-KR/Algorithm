
"""
1. 방문 처리 리스트 생성
2. edges 기준 dfs 구현
3. info 확인하여 양 혹은 늑대를 +1 하며 백트래킹 구현
4. 늑대가 양보다 많아질 경우 dfs 탈출
"""

def solution(info, edges):
    answer = []
    visited = [False] * len(info);


    def dfs(sheep, wolf):
        if sheep > wolf:
            answer.append(sheep)
        else:
            return
        for start, end in edges:
            if visited[start] and not visited[end]:
                visited[end] = True
                if info[end] == 0:
                    dfs(sheep + 1, wolf)
                else:
                    dfs(sheep, wolf + 1)
                visited[end] = False
                
    visited[0] = True
    dfs(1, 0)
    return max(answer)