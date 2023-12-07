"""
1. 곱이 가장 큰 수가 되려면 n개의 각 자연수간 차이가 적어야 한다.
2. s//n를 n 개 배치하면 가장 큰 집합의 곱을 만들 수 있다.
3. s - (s//n) 만큼 집합의 뒤에서 1씩 더하여 오름차순을 지키며 합이 s가 되도록 한다.
"""

def solution(n, s):
    answer = []
    
    def make_max_multi_set():
        max_value = s // n
        
        if max_value == 0:
            result = [-1]
            return result
        
        result = [max_value for _ in range(n)]
        add_value = s - (max_value * n)

        for i in range(len(result)-1, 0, -1):
            if add_value == 0:
                break
            result[i] += 1
            add_value -= 1
            
        return result
    
    return make_max_multi_set()