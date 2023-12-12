
from collections import deque

def bfs(place):
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    
    # P를 담을 리스트
    start = []
    for x in range(5):
        for y in range(5):
            if place[x][y] == 'P':
                start.append((x, y))
    
    for x, y in start:
        q = deque()
        q.append((x, y))
        # 방문 처리 리스트
        visited = [[0]*5 for i in range(5)]
        # 경로 길이 리스트
        distance = [[0]*5 for i in range(5)]
        visited[x][y] = 1
        while q:
            x, y = q.popleft()
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                # 범위 벗어나면 건너뜀
                if nx >= 5 or ny >= 5 or nx < 0 or ny < 0:
                    continue
                # 이미 방문한 경우 건너뜀
                if visited[nx][ny]:
                    continue
                # 파티션인 경우 건너뜀
                if place[nx][ny] == 'X':
                    continue
                # P를 만나고 맨해튼 거리가 2보다 작으면 실패 (0 반환)
                if place[nx][ny] == 'P' and distance[x][y] <= 1:
                    return 0
                # 방문 처리
                visited[nx][ny] = 1
                # 경로 길이 갱신
                distance[nx][ny] = distance[x][y] + 1
                # 큐 추가
                q.append((nx, ny))
    # 모든 조건 통과할 경우 성공 (1 반환)       
    return 1
                    
    
def solution(places):
    answer = []
    for place in places:
        answer.append(bfs(place))
    return answer