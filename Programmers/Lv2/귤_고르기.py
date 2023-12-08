import operator

def solution(k, tangerine):
    answer = 0
    total_tangerine = {}
    
    
    def init_total_tangerine():
        for t in tangerine:
            if t in total_tangerine:
                total_tangerine[t] += 1
            else:
                total_tangerine[t] = 1
                
    def fill_box(total_tangerine):
        count = 0
        result = 0
        for t in total_tangerine:
            if k <= count:
                break
            count += t[1]
            result += 1
        return result
                
        
    init_total_tangerine()
    total_tangerine = sorted(total_tangerine.items(), key=lambda t : t[1], reverse=True)
    return fill_box(total_tangerine)