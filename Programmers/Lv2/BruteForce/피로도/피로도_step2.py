# 백트레킹 사용
result = 0


def back(k, count, dungeons, visited):
    global result
    if count > result:
        result = count

    for i in range(len(dungeons)):
        if not visited[i] and k >= dungeons[i][0]:
            visited[i] = True
            back(k - dungeons[i][1], count + 1, dungeons, visited)
            visited[i] = False


def solution(k, dungeons):
    visited = [False] * len(dungeons)
    back(k, 0, dungeons, visited)
    return result


k = 80
dungeons = [[80, 20], [50, 40], [30, 10]]
print(solution(k, dungeons))
