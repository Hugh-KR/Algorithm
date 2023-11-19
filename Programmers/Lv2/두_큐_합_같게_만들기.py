
def solution(queue1, queue2):
    error = -1
    count = 0
    limit = len(queue1) * 3
    
    sum_of_queue1 = sum(queue1)
    sum_of_queue2 = sum(queue2)
    
    total_queue = queue1 + queue2
    
    queue1_start_index = 0
    queue1_end_index = len(queue1)
    
    while count < limit:
        
        if sum_of_queue1 == sum_of_queue2:
            return count
        
        if sum_of_queue1 > sum_of_queue2:
            sum_of_queue2 += total_queue[queue1_start_index]
            sum_of_queue1 -= total_queue[queue1_start_index]
            queue1_start_index = (queue1_start_index + 1) % len(total_queue)
            count+=1
            continue
            
         
        if sum_of_queue1 < sum_of_queue2:
            sum_of_queue1 += total_queue[queue1_end_index]
            sum_of_queue2 -= total_queue[queue1_end_index]
            queue1_end_index = (queue1_end_index + 1) % len(total_queue)
            count+=1
            continue
        
    return error
    
    
queue1 = [1, 1, 1, 8, 10, 9]
queue2 = [1, 1, 1, 1, 1, 1]

print(solution(queue1, queue2))