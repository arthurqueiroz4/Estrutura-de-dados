 
class Node:
    def __init__(self,data):
        self.data=data
        self.left = None
        self.right = None
        self.father = None
        self.isLeft = False

    def setLeft(self, data):
        self.left = Node(data)
        self.isLeft = True

    def setRight(self, data):
        self.right = Node(data)
        self.isLeft = False

class BinTree:
    def __init__(self, root = None):
        self.root =root

    def preOrder(self, root):
        if root == None:
            return
        print(root.data,sep="-->", end="-->")
        self.preOrder(root.left)
        self.preOrder(root.right)

    
    def inOrder(self, root):
        if root == None:
            return
        self.inOrder(root.left)
        print(root.data,sep="-->", end="-->")
        self.inOrder(root.right)

    def postOrder(self, root):
        if root == None:
            return
        self.postOrder(root.left)        
        self.postOrder(root.right)
        print(root.data,sep="-->", end="-->")

    @staticmethod
    def countNodesRecursive(root):
        if root is None:
            return 0
        return 1 + BinTree.countNodesRecursive(root.left) + BinTree.countNodesRecursive(root.right)
    
    @staticmethod
    def countNodesIterative(root):
        if root is None:
            return 0
        
        stack = [root]
        count = 0

        while stack:
            node = stack.pop()
            count += 1

            if node.left:
                stack.append(node.left)
            if node.right:
                stack.append(node.right)
        return count
    
    @staticmethod
    def accessNodes(root : Node):
        if root is None:
            return
        print(root.data)
        BinTree.accessNodes(root.left)
        BinTree.accessNodes(root.right)
    




# Crie alguns nós
root = Node(1)
root.setLeft(2)
root.setRight(3)
root.left.setLeft(4)
root.left.setRight(5)
root.right.setLeft(6)
root.right.setRight(7)

# Construa uma árvore binária
tree = BinTree(root)

# Teste os diferentes tipos de travessias (percurso)
# print("Pre-Order Traversal:")
# tree.preOrder(tree.root)
# print("\n")

# print("In-Order Traversal:")
# tree.inOrder(tree.root)
# print("\n")

# print("Post-Order Traversal:")
# tree.postOrder(tree.root)
print(BinTree.countNodesRecursive(root))
print(BinTree.countNodesIterative(root))
print(BinTree.accessNodes(root))