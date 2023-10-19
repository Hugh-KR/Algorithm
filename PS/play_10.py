'''
요구사항
1. 모험가의 수 N이 주어짐
2. 공포도가 X인 모험가는 반드시 X명 이상으로 구성한 모험가 그룹에 참여
3. 여행을 떠날 수 있는 그룹 수의 최댓값 구하기
4. 꼭 모든 모험가가 여행을 떠날 필요는 없다
'''

import sys

n = int(sys.stdin.readline().rstrip())
num_advent = list(map(int, sys.stdin.readline().rstrip().split()))

count = 0
result = 0

def travelerGroupMaximum(fear):
    global count, result

    count += 1
    if count >= fear:
        result += 1
        count = 0

for fear in num_advent:
    travelerGroupMaximum(fear)

print(result)