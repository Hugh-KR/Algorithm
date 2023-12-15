"""
1. 곡괭이 수 * 5 만큼의 광석만 캘 수 있으므로 광석의 크기가 이보다 더 클 경우 잘라준다.
2. 광물을 연속해서 5개 캐야하므로 5개씩 광물을 잘라 새로운 배열에 저장한다. 
    -> 5개씩 캐야하기에 diamond기준 정렬 가능 (큰 것과 큰 것의 매칭)
3. 광물은 주어진 순서대로, 곡괭이는 순서가 상관없으므로 광물을 다이아몬드, 철, 돌 순서대로 정렬한다.
4. 광물의 갯수만큼 반목하며 광물을 캔다
"""
   
# 곡괭이 수 * 5 만큼의 광석만 캘 수 있으므로 광석의 크기가 이보다 더 클 경우 잘라준다
def slice_minerals(picks, minerals):
    sum = 0
    # 사용 가능한 곡괭이의 수를 구한다.
    for pick in picks:
        sum += pick
    # 곡괭이로 캘 수 있는 광물만큼 자른다.
    use = sum * 5
    if len(minerals) > use:
        minerals = minerals[:use]   
    return minerals

# 광물을 연속해서 5개 캐야하므로 5개씩 광물을 잘라 새로운 배열에 저장한다.
def make_minerals_list(minerals):
    # 각각 다이아, 철, 돌
    # 다섯 개로 나누어지지 않는 마지막 부분 대비해 배열 + 1
    minerals_list = [[0,0,0] for _ in range(len(minerals)//5+1)]
    for i in range(len(minerals)):
        if minerals[i] == 'diamond':
            # 하나의 배열에 다섯개씩 채워넣음
            # 0,1,2,3,4 -> 0
            # 5,6,7,8,9 -> 1
            minerals_list[i//5][0] += 1
        if minerals[i] == 'iron':
            minerals_list[i//5][1] += 1
        if minerals[i] == 'stone':
            minerals_list[i//5][2] += 1
    # 광물의 순서를 다이아, 철, 돌 순서대로 정렬해줌
    # lambda의 첫 번째 인자를 기준으로 먼저 내림차순 정렬, 그 다음 두 번째, 세 번째 순서로 내림차순 
    minerals_list.sort(key=lambda x:(-x[0],-x[1],-x[2]))
    return minerals_list

# 광물의 갯수만큼 반목하며 광물을 캔다
def make_result(picks, minerals_list):
    result = 0
    for mineral in minerals_list:
        diamond, irom, stone = mineral
        for i in range(len(picks)):
            # 다이아 곡괭이가 있을 경우
            if picks[i] > 0 and i == 0:
                # 곡괭이 사용
                picks[i] -= 1 
                result += (diamond + irom + stone)
                break
            # 철 곡괭이가 있을 경우
            if picks[i] > 0 and i == 1:
                picks[i] -= 1 
                result += ((diamond*5) + irom + stone)
                break
            # 돌 곡괭이가 있을 경우
            if picks[i] > 0 and i == 2:
                picks[i] -= 1 
                result += ((diamond*25) + (irom*5) + stone)
                break
    return result      
    
    
def solution(picks, minerals):
    minerals = slice_minerals(picks, minerals)
    minerals_list = make_minerals_list(minerals)
    return make_result(picks, minerals_list)