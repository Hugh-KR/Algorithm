# import sys

# n = int(sys.stdin.readline().rstrip())
# commend = list(sys.stdin.readline().rstrip().split())

# x, y = 1, 1

# def right() :
#     global n, x, y
#     if y < n:
#         y += 1

# def left() :
#     global n, x, y
#     if y > 1:
#         y -= 1

# def up() :
#     global n, x, y
#     if x > 1:
#         x -= 1

# def down() :
#     global n, x, y
#     if x < n:
#         x += 1
    
# for com in commend:
#     if com == "R" :
#         right()
#     elif com == "L" :
#         left()
#     elif com == "U" :
#         up()
#     elif com == "D" :
#         down()

# print(x, y)

n = int(input())
commend = input().split()
x ,y = 1, 1

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]
commend_type = ['U', 'R', 'D', 'L']

def validateRightRange(nx, ny):
    return (nx >= 1 and ny >= 1 and nx <= 5 and ny <= 5)

for com in commend:
    for i in range(len(commend_type)):
        if com == commend_type[i]:
            nx = x + dx[i]
            ny = y + dy[i]

    if not validateRightRange(nx, ny):
        continue

    x, y = nx, ny

print(x, y)



