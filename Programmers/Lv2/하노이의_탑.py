"""
원판을 옮길 출발점, 도착점, 보조 기둥 정의

1
2
3

3   2   1

    1
3   2

    1
    2   3
    
1   2   3

        2
1       3

        1
        2
        3
"""

result = []

def hanoi(n, start, end, temp):
    print(start, end)
    # 옮겨야 할 원판이 하나인 경우 도착점으로 이동시키고 종료
    if n == 1:
        result.append([start, end])
        return
    
    # n-1 개의 원반 보조 기둥으로 이동 -> 마지막 기둥 보조로 사용
    hanoi(n-1, start, temp, end)
    # 가장 큰 원반을 목적지로 이동
    result.append([start, end])
    # n-1 개의 원반 도착점으로 이동 -> 첫번 째 기둥 보조로 사용
    hanoi(n-1, temp, end, start)
    
def solution(n):
    # n개의 원반 1번 기둥 에서 3번 기둥으로 이동 2번 기둥은 보조로 사용 
    hanoi(n, 1, 3, 2)
    
    return result