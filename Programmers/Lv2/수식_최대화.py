from itertools import permutations
from re import split

def solution(expression):
    values = []
    
    for priority in permutations(['*', '+', '-'], 3):
        # 피연산자 저장
        operands = list(map(int, split('[\*\+\-]', expression)))
        # 연산자 저장
        operators = [op for op in expression if op in '*+-']
        print(operators)
        
        # 우선순위대로 연산 수행
        for op in priority:
            while op in operators:
                # i번째 연산자는 i번째 피연산자와 i+1번째 피연산자에 대한 연산을 수행한다.
                i = operators.index(op)
                
                # 별도로 저장한 피연산자를 사용한 연산 진행
                if op == '*':
                    value = operands[i] * operands[i+1]
                if op == '+':
                    value = operands[i] + operands[i+1]
                if op == '-':
                    value = operands[i] - operands[i+1]
                
                # 피연산자 리스트 업데이트
                operands[i] = value
                operands.pop(i+1)
                # 연산자 리스트 업데이트
                operators.pop(i)
        # 순열 결과 저장
        values.append(operands[0])
    # 절댓값중 최댓값 출력
    return max(abs(value) for value in values)