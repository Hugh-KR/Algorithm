"""
1. 유저의 현재 피로도(k) 와 각 던전의 최소 필요 피로도, 소모 피로도 주어짐
2. 유저가 탐험할 수 있는 최대 던전 수 return

* 던전의 개수 == 1 이상 8 이하 (완탐 가능)
"""

# permutations 사용
from itertools import permutations


def solution(k, dungeons):
    # 최종 결과 저장할 변수
    answer = 0
    # 예제 기준 [0,1,2]를 사용해 최대 길이 3인 순열을 구한다
    # 순열 -> 사용된 원소 재사용 가능
    permu = list(permutations([x for x in range(len(dungeons))], len(dungeons)))

    for p in permu:
        temp = k
        # 탐색한 던전 수 저장
        result = 0
        for i in p:
            # 최소 필요 피로도 만족하지 않을 경우 던전 탐색 종료
            if dungeons[i][0] > temp:
                break
            # 만족할 경우 소모 피로도 적용
            temp -= dungeons[i][1]
            # 탐색한 던전 수 갱신
            result += 1
        # 더 많이 탐색했다면 갱신
        answer = max(answer, result)

    return answer
