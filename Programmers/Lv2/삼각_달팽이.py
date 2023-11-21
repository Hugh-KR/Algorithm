
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
