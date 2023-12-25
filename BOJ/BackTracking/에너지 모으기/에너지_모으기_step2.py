
"""
1. 에너지 구슬 하나 고르기
2. 선택한 에너지 구슬 i 제거
3. i-1 * i+1의 에너지 모으기
4. 재귀를 통해 회귀
5. 제거한 구슬 다시 추가 -> 구슬을 선택하는 모든 경우의 수 구하기
5. 모을 수 있는 에너지의 최댓값 출력
"""

import sys
input = sys.stdin.readline

n = int(input())
numbers = list(map(int, input().split()))
result = 0
def back(energy):
    global result
    # 더 이상 탐색할 수 없다면, 현재 값 비교해서 더 큰 값으로 교체
    if len(numbers) == 2:
        result = max(result, energy)
        return
    
    for i in range(1, len(numbers)-1):
        # i 번째 구슬을 제거했을 경우
        mul = numbers[i-1] * numbers[i+1]
        # 제거한 구슬 임시 저장
        temp = numbers.pop(i)
        # 재귀
        back(energy+mul)
        # 제거한 위치에 다시 구슬 저장 -> 모든 경우 탐색하기위해(순열)
        numbers.insert(i,temp)


back(0)
print(result)