"""

입력값
1. 사람의 수
2. 각각의 사람에게 인사를 할 때, 잃은 채력이 1번 사람부터 순서대로 들어옴
3. 얻는 기쁨이 1번 사람부터 순서대로 들어옴 

- 얻을 수 있는 최대 기쁨 출력하기

조합 -> 시간 복잡도 (N) C (N//2)
순열 -> !(N)

"""

import sys
from itertools import combinations
input = sys.stdin.readline

# 사람의 수
n = int(input())
# 각각의 사람에게 인사를 할 때, 잃은 채력
L = list(map(int, input().split()))
# 각각의 사람에게 인사를 할 때, 얻은 기쁨
J = list(map(int, input().split()))


# 사람에 따른 소진 채력, 얻은 기쁨 결합
people = []
for i in range(n):
    people.append((L[i], J[i]))

# 잃은 채력의 합이 100보다 작을 경우
if sum(L) < 100:
    # 얻은 기쁨의 합 출력
    print(sum(J))
    
# 그게 아니라면 조합에 따른 최대 기쁨 도출
else:
    # 최대 기쁨
    max_happy = 0
    for i in range(n):
        # 중복 없이 i개를 뽑는 경우의 수
        combi = list(combinations(people, i+1))
        print(combi)
        
        for com in combi:
            max_health = 100
            happy = 0
            for c in range(len(com)):
                # 조합에 따라 채력 소진 및 기쁨 충전
                max_health -= com[c][0]
                happy += com[c][1]
            # 현재 최대 채력이 0보다 크고 얻은 기쁨이 최대 기쁨보다 큰 경우 최대 기쁨 갱신
            if max_health > 0 and happy > max_happy:
                max_happy = happy
                
    # 최대 기쁨 출력
    print(max_happy)


