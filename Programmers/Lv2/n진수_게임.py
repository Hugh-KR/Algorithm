def solution(n, t, m, p):
    
    def is_formal_transformator(n, target_number):
    
        array = "0123456789ABCDEF"
        
        quotient, remainder = divmod(n, target_number)
 
        if quotient == 0:
            return array[remainder]
        if quotient != 0:
            return is_formal_transformator(quotient, target_number) + array[remainder]
            
            
    total = ''
    result = ''
    
    for start_number in range(t * m):
        total += str(is_formal_transformator(start_number, n))
        
    for make_result in range(p-1, t * m, m):
        result += total[make_result]
        
    return result.upper()


n, t, m, p = 2, 4, 2, 1
print(solution(n,t,m,p))