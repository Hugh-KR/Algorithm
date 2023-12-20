"""
* 각 사람의 부모는 최대 한 명만 주어짐
입력에서 요구한 두 사람의 촌수를 나타내는 정수 구하기
"""

import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**7)

# 전체 사람의 수
n = int(input())
# 촌수를 계산해야 하는 서로 다른 두 사람의 번호
a, b = map(int, input().split())
# 부모 자식간의 관계 개수
m = int(input())
# 그래프 생성
graph = [[ ] for _ in range(n+1)]
# 방문 처리 리스트
visited = [False] * (n+1)

for _ in range(m):
    # 부모 자식간의 관계
    x, y = map(int, input().split())
    # 양방향 그래프 구성(가족)
    graph[x].append(y)
    graph[y].append(x)
    
# 결과 저장
result = 0
# 촌수 카운트
count = 0
# [2] -> [1, 7, 8, 9] -> [2, 3] = 3 발견
def dfs(start):
    # 글로벌 선언
    global result, count
    # 촌수 계산 끝나면 종료
    if start == b:
        result = count
    # 가족 방문 처리
    visited[start] = True
    for i in graph[start]:
        # 아직 결과가 나오지 않았다면
        if result: continue
        # 이미 방문한 가족이라면
        if visited[i]: continue 
        count+=1
        dfs(i)
        # 돌아가며 카운트 감소
        count-=1

dfs(a)
# result가 1 이상이라면 그대로 출력
# 아니라면 -1 출력
print(result if result else -1)
