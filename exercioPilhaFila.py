from queueExercicio import Queue, Node, Stack

def inverterFilaComPilha(queue: Queue):
    stack = Stack()
    while not queue.isEmpty():
        stack.push(queue.deQueue())
    while not stack.isEmpty:
        queue.enQueue(stack.pop())

def inverterPilhaComFila(stack: Stack):
    queue = Queue()
    while not stack.isEmpty():
        queue.enQueue(stack.pop())
    while not queue.isEmpty:
        stack.push(queue.deQueue)
    return stack

def ordernarKprimeiros(queue : Queue, k : int):
    newStack = Stack()
    for x in range(k):
        newStack.push(queue.deQueue())
    for x in range(k):
        queue.enQueue(newStack.pop())
    for i in range(queue.size-k):
        queue.enQueue(queue.deQueue())
    
    return queue

def stackIsConsecutive(stack : Stack):
    newStack = Stack()
    mantem = Stack()

    

    while not stack.isEmpty():
        jorge = stack.pop()
        newStack.push(jorge)
        mantem.push(jorge)

    while not newStack.isEmpty():
        try:
            var1 = newStack.pop()
            var2 = newStack.pop()
        except:
            break

        print(var1, var2, abs(var1-var2))
        if abs(var1-var2) != 1:
            return False
    
    
    return True



class FilaComPilha:
    def __init__(self):
        self.stack_1 = Stack()
        self.stack_2 = Stack()
    
    def enQueue(self, data):
        self.stack_1.push(data)
    
    def deQueue(self):
        if not self.stack_2.isEmpty():
            return self.stack_2.pop()
        
        while not self.stack_1.isEmpty():
            self.stack_2.push(self.stack_1.pop())
        
        return self.stack_2.pop()
    

queue = Queue()
queue.enQueue(1)
queue.enQueue(2)
queue.enQueue(3)
queue.enQueue(4)
queue.enQueue(5)
ordernarKprimeiros(queue, 3)
#queue.printar()

stack = Stack()
stack.push(4)
stack.push(5)
stack.push(-2)
stack.push(-3)
stack.push(11)
stack.push(11)
stack.push(5)
stack.push(6)
stack.push(20)
print(stackIsConsecutive(stack))
