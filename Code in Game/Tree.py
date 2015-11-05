class Node():
    self.left = None
    self.right = None
    self.data = None


class Tree(object):
    def __init__(self):
        self.root = None

    def binary_insert(root, node):
        if root is None:
            root = node
        else:
            if root.data > node.data:
                if root.left == None:
                    root.left = node
                else:
                    binary_insert(root.left, node)
            else:
                if root.right == None:
                    root.right = node
                else:
                    binary_insert(root.right, node)


    def walk(node):
        """ iterate tree in pre-order depth-first search order """
        yield node
        for child in node.children:
            for n in walk(child):
                yield n

tree = Tree()


class Segment():
    def __ini__(self, alt, index_start, size):
        self.alt = alt
        self.index_start = index_start
        self.size = size


#Find segments of Flat Ground
last_alt = -1
index_start = -1
size = -1
for i in range(len(surface)):
    if surface[i] == last_alt:
        size+=1
    else:
        if size >= 10:
            segment = Segment(last_alt, index_start, size)
            segments.append(segment)
        last_alt = surface[i]
        index_start = i
        size = 1

segments.sort(key=lambda x: math.sqrt(x.alt*x.size))        