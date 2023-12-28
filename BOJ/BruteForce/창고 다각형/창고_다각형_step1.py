"""

입력값
1. 기둥의 개수
2. 기둥의 위치(x), 높이(y)
 
- 가장 작은 창고 다각형 만들기
- 최대 높이 전 까지 돌면서 다음 기둥이 현재 기둥보다 높으면 max_height에 저장하고 갱신
"""

import sys
input = sys.stdin.readline

n = int(input())

list = []
for i in range(n):
    x, y = map(int, input().split())
    list.append([x, y])
list.sort()

# 가장 높은 기둥의 위치, 높이 파악
max_height = 0
index = 0
for i in range(len(list)):
    if list[i][1] > max_height:
        max_height = list[i][1]
        index = i


# 처음에서 가장 높은 기둥까지
# 초기 높이
temp = list[0][1]
for i in range(index):
    if temp < list[i+1][1]:
        max_height += temp * (list[i+1][0] - list[i][0])
        temp = list[i+1][1]
    else:
        max_height += temp * (list[i+1][0] - list[i][0])


# 끝에서 가장 높은 기둥까지
# 초기 높이
temp = list[-1][1]
for i in range(n-1, index, -1):
    if temp < list[i-1][1]:
        max_height += temp * (list[i][0] - list[i-1][0])
        temp = list[i-1][1]
    else:
        max_height += temp * (list[i][0] - list[i-1][0])

# 결과 출력
print(max_height)
