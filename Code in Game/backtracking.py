import sys
import math

# Auto-generated code below aims at helping you parse
# the standard input according to the problem statement.
default_movements = [[1,0, "SOUTH"],[0,1, "EAST"],[-1,0, "NORTH"],[0,-1, "WEST"]]
cur_state = 0
start = [0,0]
end = [0,0]
teleporters = []

L, C = [int(i) for i in input().split()]

grid = [["" for x in range(0,C)] for x in range(0,L)]

visited = [["" for x in range(0,C)] for x in range(0,L)]

for i in range(L):
    row = input()
    for j in range(len(row)):
        grid[i][j] = row[j]
        if row[j] == "@":
            start = [i,j]
        elif row[j] == "$":
            end = [i,j]
        elif row[j] == "T":
            teleporters.append([i,j])

path = []

print(end, file = sys.stderr)

def backtracking(cur_pos, cur_path, last_move):
    global path, visited, cur_state, default_movements
    x = cur_pos[0]
    y = cur_pos[1]
    
    movements = default_movements[:]
    
    for i in range(len(movements)):
        if movements[i][2] == last_move:
            movements.insert(0,movements.pop(i))
    
    
    print("Cur_pos:", x, y, file = sys.stderr)
    
    while cur_pos[0] != end[0] or cur_pos[1] != end[1]:
        print("inicio while", file = sys.stderr)
        if grid[x][y] == "S" or grid[x][y] == "E" or grid[x][y] == "N" or grid[x][y] == "W":
            if grid[x][y] == "S":
                print("Force SOUTH", file = sys.stderr)
                cur_pos[0] += 1
                cur_pos[1] += 0
                direction = "SOUTH"
            elif grid[x][y] == "E":
                print("Force EAST", file = sys.stderr)
                cur_pos[0] += 0
                cur_pos[1] += 1
                direction = "EAST"
            elif grid[x][y] == "N":
                print("Force NORTH", file = sys.stderr)
                cur_pos[0] += -1
                cur_pos[1] += 0
                direction = "NORTH"
            elif grid[x][y] == "W":
                print("Force WEST", file = sys.stderr)
                cur_pos[0] += 0
                cur_pos[1] += -1
                direction = "WEST"
                
            cur_path.append(direction)
            if backtracking(cur_pos, cur_path, direction):
                print("vero", file = sys.stderr)
                path = cur_path
                return True
            else:
                print("Desfez", file = sys.stderr)
                visited[x][y] = 0
                cur_path.pop(len(cur_path)-1)
        else:
            if grid[x][y] == "I":
                default_movements = default_movements[::-1]
            if grid[x][y] == "T":
                print("Teleported from", cur_pos,file = sys.stderr)
                cur_pos = teleporters.pop(0)
                x = cur_pos[0]
                y = cur_pos[1]
                teleporters.append(cur_pos)
                print("Teleported to", cur_pos,file = sys.stderr)
                        
            while movements:
                
                m = movements.pop(0)

                x = cur_pos[0] + m[0]
                y = cur_pos[1] + m[1]
                direction =  m[2]
            
                print("Try X:", x, file = sys.stderr)
                print("Try Y:", y, file = sys.stderr)
                print("Direction:", direction, file = sys.stderr)
                
                try:
                   # if visited[x][y] == 1:
                    #    continue
                    if grid[x][y] == "#":
                        continue
                    elif grid[x][y] == "X":
                        if cur_state == 0:
                            continue
                        else:
                            grid[x][y] = ""
                    elif grid[x][y] == "B":
                        if cur_state == 0:
                            cur_state = 1
                        else:
                            cur_state = 0
                        print("State", cur_state,file = sys.stderr)
                        
                    print ("Next_pos",x, y, file = sys.stderr)
                    
                    cur_path.append(direction)
                    cur_pos[0] = x
                    cur_pos[1] = y
                    #visited[x][y] = 1
                        
                    if backtracking(cur_pos, cur_path, direction):
                        print("vero", file = sys.stderr)
                        path = cur_path
                        return True
                    else:
                        print("Desfez", file = sys.stderr)
                        #visited[x][y] = 0
                        cur_path.pop(len(cur_path)-1)
                except:
                    print("Erroooou", file = sys.stderr)
                    pass
            else:
                return False
    else:
        print("Final while", file = sys.stderr)
        return True
        
def build_path(input):
    if input:
        print("vero", file = sys.stderr)
        path = cur_path
        return True
    else:
        print("Desfez", file = sys.stderr)
        visited[x][y] = 0
        cur_path.pop(len(cur_path)-1)

backtracking(start, [], "SOUTH")

for i in path:
    print(i)
