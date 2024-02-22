# from itertools import combinations

# n = [int(input()) for _ in range(9)]
# for c in combinations(n, 7):
#     if sum(c) == 100:
#         for result in sorted(c):
#             print(result)
#         break


# combinations 없이

n = [int(input()) for _ in range(9)]
n.sort() # 처음 부터 정렬
total = sum(n)

# 함수 사용으로 return 한 번으로 탈출
def f():
    for i in range(8):
        for j in range(i+1, 9):
            if total - n[i] - n[j] == 100:
                for k in range(9):
                    if k != i and k != j:
                        print(n[k])      
                return
            

f()  
                    
            