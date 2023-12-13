"""
-1, +1, -10, +10, -100, +100...
* 0 층으로 내려가는 마법의 돌 최소값 구하기

1. 현재 자릿값 6~9 -> 10 만들기
2. 현재 자릿값 5 -> 다음 자릿값 5~9인 경우, 10 만들기 -> 0~4인 경우, 0 만들기
3. 현재 자릿값 0~4 -> 0 만들기

* 5~9일 경우 10으로 만드는 이유는 555의 경우 올릴 경우 14 내릴 경우 15임
"""

def solution(storey):
    answer = 0
    while storey:
        remain = storey % 10
        
        # 현재 자릿값 6~9 -> 10 만들기
        if 6 <= remain <= 9:
            # 10을 만들기위해 +1 버튼을 누른 값
            storey += 10 - remain
            answer += 10 - remain
            
        # 현재 자릿값 0~4 -> 0 만들기
        if 0 <= remain <= 4:
            # 0을 만들기 위해 -1 버튼을 누른 값
            storey -= remain
            answer += remain
            
        # 현재 자릿값 5 -> 다음 자릿값 5~9인 경우, 10 만들기 -> 0~4인 경우, 0 만들기
        if remain == 5:
            # 다음 자릿값 5~9인 경우 10 만들기
            if 5 <= (storey // 10) % 10 <= 9:
                storey += 10 - remain
                answer += 10 - remain
            # 다음 자릿값 0~4인 경우 0 만들기
            elif 0 <= (storey // 10) % 10 <= 4:
                storey -= remain
                answer += remain
                
        storey //= 10
        
    return answer