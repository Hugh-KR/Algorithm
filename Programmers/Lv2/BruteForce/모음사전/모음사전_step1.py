"""
1. 주어진 알파벳 모음만을 사용하여 만들 수 있는, 길이 5 이하의 모든 단어가 수록되어 있음
2. 단어 하나가 주어질 때, 이 단어가 사전에서 몇 번째 단어인지 return

* 중복 순열을 사용하여 가능한 모든 조합 구하기
"""

# 중복 순열 라이브러리
from itertools import product

def solution(word):
    words = []
    
    for i in range(1, 6):
        for w in product(['A','E','I','O','U'], repeat=i):
            words.append(''.join(w))
    
    words.sort()
    return words.index(word)+1