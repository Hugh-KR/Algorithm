from collections import defaultdict
import sys
input = sys.stdin.readline
N = int(input())
turn = int(input())
candidates = list(map(int, input().strip().split()))


# 각 후보자의 추천 횟수를 기록하는 딕셔너리
candidates_dict = dict()

for candidate in candidates:
    
    # 추천 횟수 증가
    candidates_dict[candidate] += 1
    
    # 추천 받은 사람의 수가 사진틀보다 크다면
    # 추천 받은 사람의 사진중에서 하나를 삭제해야한다.
    if len(candidates_dict) > N:
        num = sys.maxsize
        
        # 반복문을 통해 추천 받은 사람을 확인
        for i in candidates_dict:
            
            # 추천 받은 사람이 기본에 추천한 사람이라면 넘어간다.
            if i == candidate:
                continue
        
            # 추천 받은 횟수가 가자 적은 사람을 찾는다.
            if candidates_dict[i] < num:
                target = i
                num = candidates_dict[i]
                
        # 추천 받은 횟수사 가장 적은 사람을 삭제한다.
        del candidates_dict[target]

result = []
for candidate in candidates_dict:
    result.append(candidate)
print(*sorted(result))
            
        
