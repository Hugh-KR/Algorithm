# stack = []

# stack.append(5)
# stack.append(2)
# stack.append(3)
# stack.pop()
# stack.append(1)
# stack.append(4)
# stack.pop()

# print(stack[::-1])
# print(stack)

# from collections import deque

# queue = deque()

# queue.append(5)
# queue.append(2)
# queue.append(3)
# queue.append(7)
# queue.popleft()
# queue.append(1)
# queue.append(4)
# queue.popleft()

# print(queue)
# queue.reverse()
# print(queue)

def recursive_function(cnt):
    if cnt == 10:
        return
    
    print('재귀 함수 호출')
    recursive_function(cnt+1)

recursive_function(0)