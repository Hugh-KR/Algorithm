"""
한 사람의 몸무게가 w 라고 했을 때, 
그 사람은 w, 2w, w/2, (2*w)/3, (3*w)/2, (3*w)/4, (4*w)/3 몸무게를 지닌 사람들과 짝꿍이 될 수 있다.
"""

# Counter를 이용해 전체 개수 구하기
from collections import Counter

def solution(weights):
    answer = 0
    count = Counter(weights)
    
    for w in weights:
        # 타겟을 뺀 나머지 검증
        count[w] -= 1
        
        # w -> 1:1
        if w in count:
            answer += count[w] # 균형을 이루는 모든 사람 추가
        # w*2 -> 1:2 (2:4)
        if w*2 in count:
            answer += count[w*2]
        # w/2 -> 2:1 (4:2)
        if w/2 in count:
            answer += count[w/2]
        # (2*w)/3 -> 2:3
        if (2*w)/3 in count:
            answer += count[(2*w)/3]
        # (3*w)/2 -> 3:2    
        if (3*w)/2 in count:
            answer += count[(3*w)/2]
        # (3*w)/4 -> 3:4   
        if (3*w)/4 in count:
            answer += count[(3*w)/4]
        # (4*w)/3 -> 4:3    
        if (4*w)/3 in count:
            answer += count[(4*w)/3]
        
        # 검증한 타겟 다시 추가
        count[w] += 1
    
    # 모든 가능성을 검증하며 짝꿍 중복 두번씩 이루어지기 때문에 마지막 // 2
    return answer//2