
import sys

k, n = map(int, input().split())
lan_lines = [int(sys.stdin.readline()) for _ in range(k)]

start, end = 1, max(lan_lines) # 이분 탐색의 처음과 끝 위치

while start <= end:
    mid = (start + end) // 2
    
    line_count = 0
    for lan_line in lan_lines:
        line_count += lan_line // mid
        
    if line_count >= n: # n과 같거나 많이 나눌 수 있다면, 더 큰 단위로 나누기 가능
        start = mid + 1
    else: # 그게 아니라면 더 작은 단위로 나누기 시도
        end = mid - 1
        
print(end)