n, k = map(int, input().split())

coins = [int(input()) for _ in range(n)]
coins.sort(reverse=True)

count = 0
for i in coins:
    if k % i != k:
        count += k // i
        k = k % i

print(count)