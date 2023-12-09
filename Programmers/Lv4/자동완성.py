class Node(object):
    def __init__(self, key):
        self.key = key
        self.children = {}
        self.branch = 0
        
class Trie(object):
    def __init__(self):
        self.head = Node(None)
        
    # 문자열 삽입
    def insert(self, string):
        curr_node = self.head
        # 해당 문자가 몇개의 분기를 가지는지 검사.
        curr_node.branch += 1
        # 자식 Node들 중 같은 문자가 없으면 Node 새로 생성
        for char in string:
            if char not in curr_node.children:
                curr_node.children[char] = Node(char)
            # 같은 문자가 있으면 노드를 따로 생성하지 않고, 해당 노드로 이동
            curr_node = curr_node.children[char]
            curr_node.branch += 1
        
    # 문자열이 존재하는지 search
    def search(self, string):
        # 가장 아래에 있는 노드에서 부터 탐색 시작
        curr_node = self.head
        for i in range(len(string)):
            char = string[i]
            if char in curr_node.children: 
                curr_node = curr_node.children[char]
                # 단어의 branch가 1이면 그 depth를 반환한다.
                if curr_node.branch == 1:
                    return i+1
        # 단어를 끝까지 탐색해도 모든 노드의 branch가 1이상이었다면(go), 단어 길이를 반환한다.
        return len(string)
    
        
def solution(words):
    answer = 0
    trie = Trie()
    
    for word in words:
        trie.insert(word)
    for word in words:
        answer += trie.search(word)
        
    return answer