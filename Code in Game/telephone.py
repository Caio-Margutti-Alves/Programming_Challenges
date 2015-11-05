import sys, math

# Auto-generated code below aims at helping you parse
# the standard input according to the problem statement.
trees = []

class Node():
    value = -1
    children = []
    
    def __init__(self, value):
        self.value = value


class Tree():
    size = 0
    root = None

    def __init__(self, node):
        self.root = node
        size = 1
        
    def add(self, value):
        new_node = Node(value)
        node = preOrdem(self.root, value)
        for i in

    def preOrdem(node, new_node)

N = int(input())
for i in range(N):
    telephones.append(input())


for tree in trees:
    ans += tree.length

print(ans) # The number of elements (referencing a number) stored in the structure.