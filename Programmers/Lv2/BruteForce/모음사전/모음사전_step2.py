
# 백트래킹을 사용한 풀이
num = 0
word_list = ['A','E','I','O','U']

def back(word, words):
    global num
 
    # 몇 번째 단어인지 발견
    if words == word:
        return num
    # word의 길이는 1 이상 5 이하
    if len(words) == 5:
        return
    
    for w in word_list:
        num += 1
        words.append(w)
        # 몇 번째 단어인지 발견시 백트래킹 종료
        result = back(word, words)
        if result:
            return result
        words.pop()
        
def solution(word):
    return back(list(word), [])

word = "AAAAE"
print(solution(word))