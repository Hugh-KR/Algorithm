"""
오늘 반드시 끝낼 작업 X가 있고, X를 끝내기 위해 먼저 해야하는 작업의 개수 구하기

방향 그래프

X 에서 시작해서 처음으로 이동
"""

import sys
# 시간 초과 에러
# 1. 파이썬의 import()는 매개변수로 prompt message를 받는다. (따라서 입력을 받기전에 prompt message를 출력해야 한다.)
# 2. 입력받은 값의 개행 문자를 삭제시키고 반환한다.
# 이러한 단계를 거치기 때문에 input()은 비교적 속도가 느리다.
input = sys.stdin.readline

# 메모리 재귀 에러
# 파이썬의 기본 재귀 깊이 제한은 1000으로 매우 얕은 편
# 억울하게 문제를 틀리고 싶지 않다면 아래 코드를 반드시 숙지해 놓을 것
sys.setrecursionlimit(10**7) 

# 최종 출력용 전역 변수
count = 0
# 초기 값 입력
n, m = map(int, input().split())
# 그래프 초기화
graph = [[] for _ in range(n + 1)]
# 방문 처리용 리스트
visited = [False] * (n + 1)

for _ in range(m):
    # A 작업을 하려면 B 작업을 먼저 해야한다.
    # B 작업을 하기전에 A 작업을 해야하는 상황은 없다.
    a, b = map(int, input().split())
    graph[b].append(a)

# 반드시 끝낼 작업
x = int(input())


# 예제 기준 과정 5 -> 4 -> 2
def dfs(start):
    global count
    visited[start] = True
    for i in graph[start]:
        if not visited[i]:
            count += 1
            dfs(i)


dfs(x)
# X 에서 연결되는 작업 없는경우 0 출력
print(count)
