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

# def recursive_function(cnt):
#     if cnt == 10:
#         return

#     print('재귀 함수 호출')
#     recursive_function(cnt+1)

# recursive_function(0)


def recursive_function(i):
    # 100번째 호출을 했을 떄 종료되도록 종료 조건 명시
    if i == 100:
        return
    print(i, " 번째 재귀함수에서", i + 1, " 번째 재귀함수를 호출합니다.")
    recursive_function(i + 1)
    print(i, " 번째 재귀함수를 종료합니다.")


recursive_function(1)
