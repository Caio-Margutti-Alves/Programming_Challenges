import sys
import math

# Auto-generated code below aims at helping you parse
# the standard input according to the problem statement.

relations = []

n = int(input())  # the number of relationships of influence
for i in range(n):
    # x: a relationship of influence between two people (x influences y)
    relations.append([int(j) for j in input().split()])

N = max([max(l) for l in relations])

g = [[] for x in range(N)]

for R in relations:
    g[R[0]-1].append(R[1]-1)
    
for R in g:
    print(R, file = sys.stderr)

max_n = 0
   
def depth_search(node, visited, count):
    global max_n
    
    visited.append(node)
    
    if count > max_n:
        max_n = count
    
    for i in range(len(g[node])):
        if g[node][i] not in visited:
            count+=1
            depth_search(g[node][i], visited, count)
            count-=1
                
# Write an action using print
# To debug: print("Debug messages...", file=sys.stderr)

# The number of people involved in the longest succession of influences

for i in range(len(g)):
    if g[i]:
        print(g[i], file = sys.stderr)
        depth_search(i, [], 1) 

print(max_n)
