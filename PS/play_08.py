# n = 1260
# count = 0

# array = [500, 100, 50, 10]

# # 시간 복잡도 O(N)
# for coin in array:
#     count += n // coin
#     n %= coin

# print(count)

import sys

n, k = map(int, sys.stdin.readline().split())

cnt = 0

def untilItBecomesOne1(n, k):
    global cnt
    while True:
        if n == 1:
            break
        elif n % k == 0:
            n //= k
        else: 
            n-=1

        cnt+=1


def untilItBecomesOne2(n, k):
    global cnt
    while True:
        target = (n // k) * k
        cnt += (n - target)
        n = target

        if n < k:
            break
            
        cnt += 1
        n //= k

    cnt += (n - 1)


# untilItBecomesOne1(n, k)
untilItBecomesOne2(n, k)
print(cnt)