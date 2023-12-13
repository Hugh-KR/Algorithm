
def solution(skill, skill_trees):
    answer = 0
    for skill_tree in skill_trees:
        # 선행 스킬에 포함되는 경우 더해주는 문자열
        str = ''
        for s in skill_tree:
            # 선행 스킬에 포함되는 경우
            if s in skill: 
                str += s
        # 선행 스킬에 포함되는 길이만큼 앞에서 잘라낸 skill과 순서비교
        print(skill[:len(str)], str)
        if skill[:len(str)] == str:
            # 일치하는 경우 가능한 스킬트리
            answer += 1
    return answer