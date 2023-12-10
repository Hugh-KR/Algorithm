"""
* 거슬러줄 방법의 경우의 수
1. 적은 금액의 동전부터 큰 금액의 동전까지 차례대로 n원을 만들 수 있는 경우의 수를 합해나가는 방식으로 거스름돈의 경우의 수를 구할 수 있다.
"""

def solution(n, money):
    # 초기값 1을 포함한 n+1 개의 배열
    dp = [1] + [0] * n
    for m in money:
        for i in range(m, n+1):
            dp[i] = (dp[i] + dp[i-m]) % 1000000007
    # n원을 거슬러줄때 경우의 수
    return dp[n]