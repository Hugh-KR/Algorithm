
class Node:
    def __init__(self, value = 0, prev = None, next = None):
        self.value = value
        self.prev = prev
        self.next = next

# Doubled LinkedList
# class BrowserHistory(object):
#     def __init__(self, homepage):
#         new_node = Node(value=homepage)
#         self.head = new_node
#         self.tail = new_node
#         print("None")
        
#     def visit(self, url):
#         self.tail.next = Node(value=url, prev=self.tail)
#         self.tail = self.tail.next
#         print("None")

    
#     def back(self,idx):
        
#         for _ in range(idx):
#             if self.tail.prev != None:
#                 self.tail = self.tail.prev

#         print(self.tail.value)
        

#     def forward(self,idx):
#         for _ in range(idx):
#             if self.tail.next != None:
#                 self.tail = self.tail.next

#         print(self.tail.value)


# ArrayList
class BrowserHistory(object):
    def __init__(self, homepage):
        new_node = Node(value=homepage)
        self.history = [homepage]
        self.current = 0
        self.idx = 0
        print("None")
        
    def visit(self, url):
        self.current += 1
        if self.current == len(self.history):
            self.history.append(url)
        else:
            self.history[self.current] = url
        self.idx = self.current

        print("None")

    
    def back(self,steps):
        
        if self.current - steps < 0:
            self.current = 0
        else:
            self.current -= steps

        print(self.history[self.current])
        

    def forward(self,steps):
        if self.current + steps > self.idx:
            self.current = self.idx
        else:
            self.current += steps

        print(self.history[self.current])
    

browserHistory = BrowserHistory("leetcode.com")
browserHistory.visit("google.com")
browserHistory.visit("facebook.com")
browserHistory.visit("youtube.com")
browserHistory.back(1)
browserHistory.back(1)
browserHistory.forward(1)
browserHistory.visit("linkedin.com")
browserHistory.forward(2)
browserHistory.back(2)
browserHistory.back(7)

    