import sys

num_list = list(map(int, sys.stdin.readline().rstrip()))

def plusOrMultply(leftVal, rightVal):
    if leftVal <= 1 or rightVal <= 1:
        return leftVal + rightVal
    
    return leftVal * rightVal

pre = num_list[0]

for idx in range(1, len(num_list)):
    pre = plusOrMultply(pre, num_list[idx])

print(pre)
