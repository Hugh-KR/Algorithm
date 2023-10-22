n = input()

x = int(n[1])
y = int(ord(n[0]) - ord('a')) + 1

dx = [-2, -2, -1, 1, 2, 2, 1, -1]
dy = [-1, 1, 2, 2, 1, -1, -2, -2]

def validateRightRange(x, y):
    return x >= 1 and y >= 1 and x <= 8 and y <= 8

count = 0
for i in range(8):
    nx = x + dx[i]
    ny = y + dy[i]
    if not validateRightRange(nx, ny):
        continue
    count+=1

print(count)
