class Node :
    def __init__(self, value = 0, next = None):
        self.value = value
        self.next = next

class LinkedList(object):
    def __init__(self):
        self.head = None
        self.tail = None

    def append(self, value):
        new_node = Node(value)
        if self.head is None:
            self.head = new_node
            self.tail = new_node;
        else:
            self.tail.next = new_node # O(1) append
            self.tail = self.tail.next

            # current = self.head # O(n) append
            # while(current.next):
            #     current = current.next
            # current.next = new_node

    def insert(self, idx, value):
        new_node = Node(value)
        
        current = self.head
        for _ in range(idx):
            current = current.next
        
        new_node.next = current.next
        current.next = new_node

    def remove(self, idx):
        current = self.head
        for _ in range(idx-1):
            current = current.next

        current.next = current.next.next

    def get(self, idx):
        current = self.head
        for _ in range(idx):
            current = current.next
        return current.value

    
# first = Node(1)
# second = Node(2)
# third = Node(3)

# first.next = second
# second.next = third

ll = LinkedList()
ll.append(1)
ll.append(2)
ll.append(3)
ll.append(4)
ll.append(5)
ll.append(6)

ll.insert(2,0)
ll.remove(3)

# print(ll.get(1))

while (ll.head):
    print(ll.head.value, end=" ")
    ll.head = ll.head.next

