"""
*입출력 예
1  2  3  5
10 11 12 11
16 15 13 13
"""

def solution(land):
    
    for i in range(1, len(land)):
        for j in range(len(land[0])):
            # 자기 자신의 열을 뺀 나머지 중 최대값을 밑으로 더해준다
            land[i][j] += max(land[i-1][:j] + land[i-1][j+1:])

    return max(land[-1])