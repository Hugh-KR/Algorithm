
def dfs(n, computers, computer, visited): 
    visited[computer] = True
    for connect in range(n):
        # 연결된 컴퓨터
        if connect != computer and computers[computer][connect] == 1: 
            if visited[connect] == False:
                dfs(n, computers, connect, visited)
                
def solution(n, computers):
    result = 0
    visited = [False for i in range(n)]
    for computer in range(n):
        if visited[computer] == False:
            dfs(n, computers, computer, visited)
            # DFS로 최대한 컴퓨터들을 방문하고, 빠져나오게 되면 그것이 하나의 네트워크.
            result += 1
    return result