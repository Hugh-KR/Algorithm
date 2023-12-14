"""
1. 처음은 하나씩 쪼개고, 이후 두 개, 세 개씩 나누는 형식으로 for문 진행
2. 그 중 길이가 가장 작은 값을 return

"aabbaccc" 기준
i = 1 2 3 4
j = 1 2 3 4 5 6 7
    2 4 6
    3 6
    4
"""

def solution(s):
    result = []
    
    # s의 길이 1일 경우 따로 처리 -> 아래 반복문에 들어가면 돌지 않음 range(1,1):
    if len(s) == 1:
        return 1
    
    # 문자열을 가장 크게 나눴을 경우 len(s)//2
    for i in range(1, (len(s)//2)+1):
        compress_s = ''
        count = 1
        # 첫번째 문자는 미리 나눠둠
        temp = s[:i]
        for j in range(i, len(s), i):
            # 한 개, 두 개, 세 개 순서로 나눠감
            # 이전에 나눠둔 문자열과 일치할 경우 count += 1
            if temp == s[j:i+j]:
                count += 1
            else:
                # 앞서서 일치하는 문자열이 있었다면 숫자 + 문자열 붙이기
                if count != 1:
                    compress_s += str(count) + temp
                # 일치하는 문자열 없었다면 문자열만 붙임
                else:
                    compress_s += temp
                # temp 갱신
                temp = s[j:i+j]
                count = 1
        # 마지막 압축 문자열 붙이기
        if count != 1:
            compress_s += str(count) + temp
        else:
            compress_s += temp
        # 1~len(s)//2 까지 진행하며 압축한 문자열의 길이, 리스트에 추가
        result.append(len(compress_s))
    # 최솟값 출력    
    return min(result)