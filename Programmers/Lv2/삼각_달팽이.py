
# 시간 복잡도 2160.35ms
def solution(n):
    triangle_array = [[0 for row in range(col+1)] for col in range(n)]
    result = []
    
    x, y = -1, 0
    number = 1
    
    for col in range(n):
        for row in range(col, n):
            
            # Down
            if col % 3 == 0:
                x += 1
            
            # Right
            elif col % 3 == 1:
                y += 1
            
            # Up
            elif col % 3 == 2:
                x -= 1
                y -= 1
            
            triangle_array[x][y] = number
            number+=1
            
    return sum(triangle_array, [])


# 시간 복잡도 220.89ms (약 10배 개선)
def solution(n):
    # 일단 정사각형으로 만듦
    triangle = [[0] * n for _ in range(n)]
    x, y = -1, 0
    num = 1

    for col in range(n):
        for row in range(col, n):
            # Down
            if col % 3 == 0:
                x += 1
            # Right
            if col % 3 == 1:
                y += 1
            # Up
            if col % 3 == 2:
                x -= 1
                y -= 1
            triangle[x][y] = num
            num += 1
            
    result = []
    for col in range(n):
        for row in range(col+1):
            result.append(triangle[col][row])
    return result