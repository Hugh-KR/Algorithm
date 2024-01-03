"""
* 학생들의 인적사항이 주어졌을 때, 후보 키의 최대 개수를 구하라.

유일성 - 릴레이션에 있는 모든 튜플에 대해 유일하게 식별되어야 한다.
최소성 - 유일성을 가진 키를 구성하는 속성 중 하나라도 제외하는 경우 유일성이 깨지는 것을 의미한다.

set은 각 요소에 접근이 불가능함
"""
import sys
# 재귀 범위 제한
sys.setrecursionlimit(10**6)

result = []
# 조합 구하기
def back(relation, start, visited):
    
    # 현재 조합 출력
    global result
    r = []
    for j in range(0, len(relation)):
        if visited[j]:
            r.append(j)
    result.append(r)
    
    for i in range(start, len(relation)):
        # 이미 방문했다면
        if visited[i]: continue
        visited[i] = True
        # 같은 값을 탐색하지 않기 위한 start+1
        back(relation, start+1, visited)
        # 모든 경우 탐색하기위해 방문 해제
        visited[i] = False

        
def solution(relation):
    visited = [False] * len(relation[0])
    back(relation[0], 0, visited)

    # 유일성 검증
    unique = []
    for u in result:
        # relation를 순회하며 모든 relation에 대한 조합을 튜플화 한다
        temp = [tuple([r[key_index] for key_index in u]) for r in relation] 
        # 유일성 만족 확인 -> 조합의 중복을 제거했는데도 relation의 길이와 같다면
        if len(set(temp)) == len(relation):
            unique.append(u)
    
    # 유일성 만족한 리스트 중복 제거
    answer = set(unique)
    for i in range(len(unique)):
        for j in range(i+1, len(unique)):

            if len(unique[i]) == len(set(unique[i]) & set(unique[j])):
                answer.discard(unique[j])
                
    print(len(answer))
                    
        
    return len(answer)

relation = [["100","ryan","music","2"],["200","apeach","math","2"],["300","tube","computer","3"],   ["400","con","computer","4"],["500","muzi","music","3"],["600","apeach","music","2"]]
solution(relation)
