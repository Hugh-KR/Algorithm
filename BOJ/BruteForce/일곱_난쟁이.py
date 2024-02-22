from itertools import combinations

n = [int(input()) for _ in range(9)]
for c in combinations(n, 7):
    if sum(c) == 100:
        for result in sorted(c):
            print(result)
        break
