"""
* 현재 위치에서 가능한 최대 크기의 정사각형 한 변의 길이

1. 오른쪽 아래로 이동하며 값을 쌓아가기위해 가장 가장 윗 줄, 왼쪽 줄은 비교를 위해 고정 -> O
2. 작은 정사각형부터 하나하나 값을 쌓아가면서 해를 구함 -> O
3. 쌓인 DP에서 가장 큰 값 구함 (가장 큰 정사각형 한 변의 길이) -> O
4. 한 변의 길이 제곱하여 넓이 구함 -> O
"""

def solution(board):
    n = len(board)
    m = len(board[0])
    
    # dp 초기화 -> 오른쪽 아래로 이동하며 값을 쌓아가기위해 가장 윗 줄과 왼쪽 줄은 비교를 위해 고정해둔다
    dp = [[0]*m for _ in range(n)]
    dp[0] = board[0]
    for i in range(1,n):
        dp[i][0] = board[i][0]
    
    # 비교를 위해 고정해둔 줄을 제외하고 나머지 부분 탐색
    for x in range(1, n):
        for y in range(1, m):
            # board에서 1인 경우
            if board[x][y] == 1:
                # 왼쪽 대각선, 오른쪽, 윗쪽을 비교, 가장 작은 값에 1을 더해감 
                # -> 현재 위치에서 가능한 최대 크기의 정사각형 한 변의 길이
                dp[x][y] = min(dp[x-1][y-1], dp[x-1][y], dp[x][y-1]) + 1
    
    # 가장 큰 정사각형 한 변의 길이 찾기
    result = 0
    for x in range(n):
        temp = max(dp[x])
        result = max(temp, result)

    # 가장 큰 정사각형 넓이 구하기
    return result**2