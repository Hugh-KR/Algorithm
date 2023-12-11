"""
1. set은 (0,0) -> (0,1), (0,1) -> (0,0)을 다른 요소로 취급함 
2. 출발 장소 -> 도착 장소, 도착 장소 -> 출발 장소 모두 set에 넣기
3. 결과 set 길이 // 2 출력
"""

def solution(dirs):
    answer = 0
    result = set()
    
    def move():
        x, y = 0, 0
        for dir in dirs:
            if dir == 'U' and y < 5:
                result.add(((x,y),(x,y+1)))
                result.add(((x,y+1),(x,y)))
                y += 1
            elif dir == 'D' and y > -5:
                result.add(((x,y),(x,y-1)))
                result.add(((x,y-1),(x,y)))
                y -= 1
            elif dir == 'L' and x > -5:
                result.add(((x,y),(x-1,y)))
                result.add(((x-1,y),(x,y)))
                x -= 1
            elif dir == 'R' and x < 5:
                result.add(((x,y),(x+1,y)))
                result.add(((x+1,y),(x,y)))
                x += 1
            
    move()
    return len(result) // 2