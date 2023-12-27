"""
rectangle의 원소 -> [좌측 하단 x, 좌측 하단 y, 우측 상단 x, 우측 상단 y]
"""
from collections import deque


def bfs(field, startX, startY, endX, endY):
    # 방문 처리용 리스트
    visited = [[False] * 102 for _ in range(102)]
    # 상하좌우
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    # 출발지 저장
    q = deque()
    q.append((startX*2, startY*2))
    # 출발지 방문 처리
    visited[startX*2][startY*2] = True
    
    while q:
        curX, curY = q.popleft()
        # 목적지에 도착했을 경우 종료
        if curX == endX*2 and curY == endY*2:
            break
        for i in range(4):
            nx = curX + dx[i]
            ny = curY + dy[i]
            # 이미 방문한 위치라면
            if visited[nx][ny]: continue
            # 필드의 범위를 벗어난다면
            if nx >= len(field) or ny >= len(field[0]) or nx < 0 or ny < 0: continue
            # 사각형의 내부이거나 사각형의 범위를 벗어난 경우
            if field[nx][ny] == 0 or field[nx][ny] == -1: continue
            
            # 모든 조건 통과했다면 방문처리, 큐에 넣어줌
            visited[nx][ny] = True
            q.append((nx, ny))
            # 거리 정보 갱신
            field[nx][ny] = field[curX][curY] + 1

    # 목적지 까지의 거리 반환
    return field[endX*2][endY*2] // 2
            

def solution(rectangle, characterX, characterY, itemX, itemY):
    answer = 0
    
    # 지형을 생성하기 위한 필드
    field = [[-1] * 102 for _ in range(102)]
    for r in rectangle:
        # 오류가 생기는 꺾이는 구간 해결하기위해 필드, 좌표 두배로 설정
        x1, y1, x2, y2 = map(lambda x: x*2, r)
        # 행
        for row in range(x1, x2+1):
            # 열
            for col in range(y1, y2+1):
                # 현재 사각형의 내부를 0으로 채움
                if x1 < row < x2 and y1 < col < y2:
                    field[row][col] = 0
                # 현재 사각형의 내부가 아니고 다른 사각형의 내부가 아닌경우 1로 채움-> 테두리 설정
                elif field[row][col] != 0:
                    field[row][col] = 1
                    
    return bfs(field, characterX, characterY, itemX, itemY)