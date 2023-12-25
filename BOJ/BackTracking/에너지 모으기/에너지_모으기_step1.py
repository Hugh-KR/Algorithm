"""
1. 에너지 구슬 하나를 고른다. -> 고른 구슬의 번호를 x라고 한다. 단, 첫 번째와 마지막 에너지 구슬은 고를 수 없다.
2. x번째 에너지 구슬을 제거한다.
3. Wx-1 * Wx+1의 에너지를 모을 수 있다.
4. N을 1 감소시키고, 에너지 구슬을 1번부터 N번까지로 다시 번호를 매긴다. 

해당 구슬을 선택했을때와 선택하지 않았을 때

* N과 에너지 구슬의 무게가 주어졌을 때, 모을 수 있는 에너지 양의 최댓값을 구하기

100 2 1 3 100
100 1 3 100 -> 100
100 3 100 -> 300
100 100 -> 10000

결과 -> 10400
"""

import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline
n = int(input())

numbers = list(map(int, input().split()))
result = 0

def back(energy):
    global result
    # 더 이상 탐색할 수 없다면 현재 결과 값 비교해서 더 큰 값으로 교체
    if len(numbers) == 2:
        result = max(result, energy)
        return
    
    for i in range(1, len(numbers)-1):
        # i 번째 구슬을 제거했을 경우
        mul = numbers[i-1] * numbers[i+1]
        
        # 제거한 구슬 저장
        temp = numbers.pop(i)
        # 백트레킹: 재귀가 끝나면, 제거한 구슬 다시 넣어준다 -> 모든 경우 탐색 
        back(energy+mul)
        # 끝나고 다시 넣어줌
        numbers.insert(i, temp) 
        
back(0)
print(result)