g = [[0 for x in range(0,N)] for x in range(0,N)]


def breadth_search(node):
    
    queue = []
    queue.append(node)
    
    visited = [0 for x in range(0,N)]
    visited[node] = 1
    
    b_node = -1
    b_edge = -1
    
    print("Agent",queue , file=sys.stderr)
    print("Gateway", gateways , file=sys.stderr)

    while queue:
        node = queue.pop(0)
        print("Node", node, file=sys.stderr)
        for i in range(len(g[node])):
            if g[node][i] != 0:
                if i in gateways: 
                    b_node = node
                    b_edge = i
                    queue = [] 
                    break
                elif visited[i] == 0:
                    visited[i] = 1
                    queue.append(i)
    
    print("B_node",b_node, "B_edge", b_edge, file=sys.stderr)
    return [b_node, b_edge]

for i in range(L):
    # N1: N1 and N2 defines a link between these nodes
    N1, N2 = [int(j) for j in input().split()]
    g[N1][N2] = 1
    g[N2][N1] = 1
    print(N1, N2, file=sys.stderr)

for i in g:    
    print(i, file=sys.stderr)    
    
for i in range(E):
    gateways.append(int(input())) # the index of a gateway node

# game loop
while 1:
    SI = int(input()) # The index of the node on which the Skynet agent is positioned this turn
    
    data = breadth_search(SI)
    
    print(data[0], data[1]) # Example: 0 1 are the indices of the nodes you wish to sever the link between


# Write an action using print
# To debug: print("Debug messages...", file=sys.stderr)