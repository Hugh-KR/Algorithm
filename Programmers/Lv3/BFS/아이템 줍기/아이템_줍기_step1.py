"""
1. 지형은 각 변이 x, y 축과 평행한 직사각형이 겹쳐진 형태로 표현하며, 캐릭터는 이 다각형의 둘레를 따라서 이동한다.
2. 중앙에 빈 공간이 생기는 경우 다각형의 가장 바깥쪽 테두리가 이동 경로가 됨
3. 서로 다른 두 직사각형이 꼭짓점에서 만나거나, 변이 겹치는 경우는 없음
4. 지형이 2개 이상으로 분리된 경우도 없음
5. 한 직사각형이 다른 직사각형 안에 완전히 포함되는 경우 또한 없음

[좌측 하단 x, 좌측 하단 y, 우측 상단 x, 우측 상단 y]


* 오류가 생기는 구간 -> 꺾이는 부분

3, 4
3, 5
4, 5
4, 6
2, 6

0 1 1 1 0 0
0 0 1 1 0 0
0 0 1 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0

* 정상적인 모양
0 0 0 1 1 1 1 1 0 0 0 0
0 0 0 0 0 0 0 1 0 0 0 0
0 0 0 0 0 1 1 1 0 0 0 0
0 0 0 0 0 1 0 0 0 0 0 0
0 0 0 0 0 1 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0
"""

from collections import deque

# 상하좌우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def bfs(field, startX, startY, endX, endY):
    # 방문 처리용 리스트
    visited = [[False] * 102 for _ in range(102)]
    
    q = deque()
    q.append((startX*2, startY*2))
    
    # 시작지점 방문처리
    visited[startX*2][startY*2] = True
    
    while q:
        x, y = q.popleft()
        # 목적지에 도착했다면
        if x == endX*2 and y == endY*2:
            break
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            # 이미 방문한 위치라면
            if visited[nx][ny]: continue
            # 필드의 범위를 벗어난다면
            if nx >= len(field) or ny >= len(field[0]) or nx < 0 or ny < 0: continue
            # 사각형의 내부이거나 사각형의 범위를 벗어난 경우
            if field[nx][ny] == 0 or field[nx][ny] == -1: continue
            # 모두 통과하면 방문처리하고 큐에 넣어준다
            visited[nx][ny] = True
            q.append((nx, ny))
            # 거리정보를 기록한다
            field[nx][ny] = field[x][y] + 1
            
    return field[endX*2][endY*2] // 2
                
    
    

def solution(rectangle, characterX, characterY, itemX, itemY):
    answer = 0
    
    # 지형을 생성하기위한 필드 
    field = [[-1] * 102 for _ in range(102)]
    for r in rectangle:
        x1, y1, x2, y2 = map(lambda x: x*2, r)
        for row in range(x1, x2+1):
            for col in range(y1, y2+1):
                # 현재 사각형의 내부를 0으로 채운다
                if x1 < row < x2 and y1 < col < y2:
                    field[row][col] = 0
                # 현재 사각형의 테두리 이고 다른 사각형의 내부가 아닌경우 1로 채운다
                elif field[row][col] != 0:
                    field[row][col] = 1
    
    
    return bfs(field, characterX, characterY, itemX, itemY)