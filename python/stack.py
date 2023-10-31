class Node:
    def __init__(self, data=0, next=None):
        self.data = data
        self.next = next

    def __str__(self):
        return "Node[Data=%s]" % self.data

class Stack:
    def __init__(self, data=[]) -> None:
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
            return None
        return self.head.data

    def isEmpty(self):
        return self.head is None

    @staticmethod
    def delimitorIsOk(expression: str) -> bool:
        stack = Stack([])
        for char in expression:
            if char in "([{":
                stack.push(char)
            if char in ")]}":
                try:
                    delimiter = stack.pop()
                except:
                    return False
                if delimiter == "(" and char != ")":
                    return False
                if delimiter == "{" and char != "}":
                    return False
                if delimiter == "[" and char != "]":
                    return False
        return stack.isEmpty()

    @staticmethod
    def htmlIsOk(html: str) -> bool:
        stack = Stack()
        count = 0

        while count < len(html):
            start = html.find('<', count)
            if start == -1:
                break

            end = html.find('>', start + 1)
            if end == -1:
                return False

            tag = html[start + 1:end]

            if not tag.startswith('/'):
                stack.push(tag)
            else:
                if stack.isEmpty() or stack.pop() != tag[1:]:
                    return False

            count = end + 1

        return stack.isEmpty()
    
    @staticmethod
    def infixaParaPosfixa(infixa):
        stack = Stack()
        posfixa = ""
        for char in infixa:
            if char in "+-*/()":
                
                while not stack.isEmpty() and Stack.verificaPrecedencia(stack.peek(), char):
                    op = stack.pop()

                    if op not in "()":
                        posfixa += op
                    if op is "(":
                        break
                if char is not ")":
                    stack.push(char)
                
                stack.push(char)
            else:
                posfixa += str(char)
        while not stack.isEmpty():
            operator = stack.pop()
            if operator not in "()":
                posfixa += operator
        return posfixa 

    @staticmethod
    def verificaPrecedencia(operator1, operator2):
        if operator1 in "+-" and operator2 in "+-":
            return True
        if operator1 in "+-" and operator2 in "/*" :
            return False
        if operator1 in "/*":
            return True
        
    @staticmethod
    def resolvePostfix(operation):
        stack = Stack()
        for char in operation:
            if char not in "+-*/":
                stack.push(char)
            else:
                op1 = stack.pop()
                op2 = stack.pop()
                stack.push(Stack.execOperation(char, op2, op1)) 
        return stack.peek()
    
    @staticmethod
    def execOperation(char, op1, op2):
        if char is "+":
            return int(op1) + int(op2)
        elif char is "-":
            return int(op1) - int(op2)
        elif char is "*":
            return int(op1) * int(op2)
        elif char is "/":
            return int(op1) // int(op2)
        
    @staticmethod
    def posfixoParaInfixo(operation):
        stack = Stack()
        for char in operation:
            if char not in "+-*/":
                stack.push(char)
            else:
                op1 = stack.pop()
                op2 = stack.pop()
                stack.push("("+op2+char+op1+")") 
        return stack.peek()
    
stack = Stack([3, 2, 1])

print("Testando pilha:")
print(stack.isEmpty())
print(stack.pop())
print(stack.pop())
print(stack.pop())
print("-------------------------")
print("delimitadorIsOk():")
print(Stack.delimitorIsOk("(1+2)*(5-1)"))
print(Stack.delimitorIsOk("(1+2]-1"))
print(Stack.delimitorIsOk("[((1+2)-(1-4)"))
print("-------------------------")
print("htmlIsOk():")
print(Stack.htmlIsOk("<tag></tag><></>"))
print(Stack.htmlIsOk("<html><body><p>Texto</p></body></html>"))
print(Stack.htmlIsOk("<html><body><p>Texto</body></html>"))
print("-------------------------")
print(Stack.infixaParaPosfixa("A+B"))
print(Stack.resolvePostfix("123*+5-"))
print(Stack.posfixoParaInfixo("AB+C-"))
