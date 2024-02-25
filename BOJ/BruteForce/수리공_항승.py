N, L = map(int, input().split())
repair_pos = list(map(int, input().split()))
repair_pos.sort()
pipe = [0 for _ in range(max(repair_pos)+L+1)]


def f():
    # 사용한 테이프 개수
    count = 0
    
    for pos in repair_pos:
        # 이미 막힌 구멍이라면
        if pipe[pos] >= 1.0:
            continue
        
        # 아직 막히지 않았다면 테이프 개수 추가
        count+=1
        
        # 테이프 길이만큼 물을 막고 그 위치의 좌우 0.5만큼 간격 주기
        pipe[pos-1] += 0.5
        for tape in range(pos, pos+L):
            pipe[tape] += 1.0
        pipe[pos+L] += 0.5
        
        # 모든 구멍 막혔는지 확인
        repair_count = 0
        for pos in repair_pos:
            if pipe[pos] >= 1.0:
                repair_count += 1
                
        # 모든 구멍 막혔다면 끝내고 사용한 테이프 개수 반환
        if repair_count == N:
            return count
            
    # 사용한 테이프 개수 반환
    return count    
       
        
print(f())

