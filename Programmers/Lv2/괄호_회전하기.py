"""
1. 올바른 괄호 문자열 확인하는 메서드 -> O
2. 배열 왼쪽으로 회전하는 메서드 -> O

* 파이썬은 list로 stack을 흉내냄
"""

def validate_true_brackets(rotate_s):
    # {닫는 괄호 : 여는 괄호} 형식으로 딕셔너리 생성 
    dic = {')':'(', ']':'[', '}':'{'}
    stack = []
    for r in rotate_s:
        # 여는 괄호인 경우
        if r in '([{':
            stack.append(r)
        # 닫는 괄호인 경우
        else:
            # 스택에 열린 괄호가 남아있다면
            if stack:
                top = stack.pop()
                if dic[r] != top:
                    return 0
            # 스택이 비어있다면
            else:
                return 0
    # 모든 스택을 검증하고 값이 남아있다면 0반환
    if stack:
        return 0
    # 짝이 맞으면 1반환
    return 1

def left_rotate(list_s, x):
    # 새로운 배열 만들고 초기화
    rotate_s = [None for _ in range(len(list_s))]
    for i in range(len(list_s)):
        rotate_s[i-x] = list_s[i]
    return rotate_s
        

def solution(s):
    answer = 0
    list_s = list(s)        
    for x in range(len(s)):
        rotate_s = left_rotate(list_s, x)
        answer += validate_true_brackets(rotate_s) 
    return answer