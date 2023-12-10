from itertools import permutations

def check(users, banned_id):
    for i in range(len(banned_id)):
        # 일반 사용자, 불량 사용자 길이 다르면 False 반환
        if len(users[i]) != len(banned_id[i]):
            return False
        
        for j in range(len(users[i])):
            # 불량 사용자 가려진 아이디는 비교하지 않음
            if banned_id[i][j] == "*":
                continue
            # 일반 사용자, 불량 사용자 아이디 일치하지 않으면 False 반환
            if banned_id[i][j] != users[i][j]:
                return False
    # 길이와 아이디 모두 일치하면 True 반환
    return True

def solution(user_id, banned_id):
    # 앞.뒤 포함 user_id로 만들 수 있는 모든 경우의 수 만들기
    user_permutation = list(permutations(user_id, len(banned_id)))
    ban_set = []
    
    for users in user_permutation:
        if not check(users, banned_id):
            continue
        else:
            # set으로 만들어 ban_set에 append함으로써 중복값 제거
            users = set(users)
            if users not in ban_set:
                ban_set.append(users)
    return len(ban_set)