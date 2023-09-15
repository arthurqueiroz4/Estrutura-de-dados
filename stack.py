from simpleList import Node

class Stack:
    def __init__(self, data) -> None:
        self.head = None
        if data:
            for data in data:
                self.push(data)

    def push(self, data):
        temp = Node()
        temp.data = data
        temp.next = self.head
        self.head = temp
    
    def pop(self):
        if self.head is None:
            raise IndexError
        temp = self.head.data
        self.head = self.head.next
        return temp
    
    def peek(self):
        if self.head is None:
            raise IndexError
        return self.head.data
    
    def isEmpty(self):
        return self.head is None

    @staticmethod
    def delimitorIsOk(expression : str) -> bool:
        stack = Stack([])
        for char in expression:
            if char in "([{":
                stack.push(char)
            if char in ")]}":
                try:
                    delimiter = stack.pop()
                except:
                    return False
                if delimiter is "(" and char is not ")":
                    return False
                if delimiter is "{" and char is not "}":
                    return False
                if delimiter is "[" and char is not "]":
                    return False
        if not stack.isEmpty():
            return False
        return True
    
    @staticmethod
    def htmlIsOk(html: str) -> bool:
        stack = Stack([])
        while True:
            primary = html.find('<')
            stack.push(primary)
            second = html.find('>', primary+1)
            pop = stack.pop()


stack = Stack([3,2,1])
print(stack.isEmpty())
print(stack.pop())
print(stack.pop())
print(stack.pop())
print(stack.isEmpty())
print(Stack.delimitorIsOk("(1+2)*(5-1)"))
print(Stack.delimitorIsOk("(1+2]-1"))
print(Stack.delimitorIsOk("((1+2)-(1-4)"))
