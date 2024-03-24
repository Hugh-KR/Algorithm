import sys
input = sys.stdin.readline

N, r, c = map(int, input().strip().split())
cnt = 0

def navigating_by_z(y, x, N):
    global cnt
    if y > r or y + N <= r or x > c or x + N <= c:
        cnt += N ** 2
        return 
    
    if N > 2:
        N //= 2
        navigating_by_z(y, x, N)
        navigating_by_z(y, x + N, N)
        navigating_by_z(y + N, x, N)
        navigating_by_z(y + N, x + N, N)
    else:
        if y == r and x == c:
            print(cnt)
            return
        elif y == r and x + 1 == c:
            print(cnt + 1)
            return
        elif y + 1 == r and x == c:
            print(cnt + 2)
            return
        else:
            print(cnt + 3)
            return

navigating_by_z(0, 0, 2**N)