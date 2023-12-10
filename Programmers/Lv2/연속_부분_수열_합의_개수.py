"""
1. 연속 부분수열의 최대 값 == 부분수열의 길이
2. 부분수열 * 2를 생성하고 구간별 부분수열 합 구하기 
"""

def solution(elements):
    result = set()
    
    elements_length = len(elements)
    elements = elements * 2
    
    for i in range(elements_length):
        for j in range(elements_length):
            result.add(sum(elements[j:j+i+1]))
    
    return len(result)