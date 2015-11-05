import sys, math

# Auto-generated code below aims at helping you parse
# the standard input according to the problem statement.

edges = []

def print_edges():
    for i in edges:
        print(i, file=sys.stderr)
    
def print_graph():
    for i in g:
        print(i, file=sys.stderr)    
    print("-------------------", file=sys.stderr) 
        
n = int(input()) # the number of adjacency relations
for i in range(n):
    edges.append([int(j) for j in input().split()])

N = max([max(l) for l in edges]) + 1
   
print(N, file=sys.stderr) 

g = [[] for x in range(N)]

for R in edges:
    g[R[0]].append(R[1])
    g[R[1]].append(R[0])

#print_graph()

'''nodes_influence = []

for i in range(len(g)):
    if g[i]:
        neighbors_fan_out = 0
        for node in g[i]:
            neighbors_fan_out += len(g[node])
        nodes_influence.append([neighbors_fan_out,i])

nodes_influence.sort(reverse = True)
        
print("Best guess", nodes_influence[0], file= sys.stderr)'''

best_time = N-1

longest_path = []

def depth_search(node, visited, count):
    global longest_path
    
    visited.append(node)
    
    if len(visited) > len(longest_path):
        longest_path = visited
    
    for i in range(len(g[node])):
        if g[node][i] not in visited:
            depth_search(g[node][i], visited, count)

def breadth_search(in_node):
    global best_time
    
    #print("Best_time in", best_time, file=sys.stderr)
    
    time = 0
    queue = []
    queue.append([in_node,0])
    
    visited = []
    visited.append(in_node)
    
    
    while queue:
        node = queue.pop(0)
        if node[1] >= best_time: 
            return
        else:
            for i in g[node[0]]:
               if i not in visited:
                    visited.append(i)
                    queue.append([i, node[1] +1])

    best_time = node[1]
    #print("Node", in_node, file=sys.stderr)
    #print("BestTime", best_time, file=sys.stderr)

'''for i in nodes_influence:
    if g[i[1]]:
        breadth_search(i[1])'''

for i in range(len(g)):
    if g[i]:
        print(g[i], file = sys.stderr)
        depth_search(i, [], 1) 
        
for i in longest_path:
    print("Path:",i, file = sys.stderr)
    if g[i]:
        breadth_search(i)

print(best_time) # The minimal amount of steps required to completely propagate the advertisement