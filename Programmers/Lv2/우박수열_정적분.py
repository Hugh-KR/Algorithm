
"""
1. 우박수열 구하기 -> O
2. 구간별 넓이 구하기 -> O
3. ranges에 따른 결과 구하기 -> O
"""

def solution(k, ranges):
    answer = []
    
    def make_ubak(k):
        number = k
        ubak = []
        while number != 1:  
            ubak.append(number)
            if number % 2 == 0:
                number //= 2
            elif number % 2 != 0:
                number *= 3
                number += 1 
        ubak.append(1)
        return ubak
    
    def make_extent_of_section(ubak):
        extents = []
        for i in range(len(ubak)-1):
            extent_of_section = (ubak[i] + ubak[i + 1]) / 2
            extents.append(extent_of_section)
        return extents
    
    def make_result(ubak_count, extents, ranges):
        for start, end in ranges:
            sum_of_extent = 0.0
            if start > ubak_count + end:
                answer.append(-1.0)
                continue
            for i in range(start, ubak_count + end):
                sum_of_extent += extents[i]
            answer.append(sum_of_extent)

    
    ubak = make_ubak(k)
    extents = make_extent_of_section(ubak)
    make_result(len(ubak)-1, extents, ranges)
    return answer