import sys, math

# Don't let the machines win. You are humanity's last hope...

width = int(input()) # the number of cells on the X axis
height = int(input()) # the number of cells on the Y axis

grid = [[0 for x in range(width)] for x in range(height)] 

for i in range(height):
    grid[i] = list(input()) # width characters, each either 0 or .

for i in range(height):
    print(grid[i], file=sys.stderr)

for i in range(height):
    for j in range(width):
        for k in range(
        x1 = -1
        y1 = -1
        x2 = -1
        y2 = -1
        x3 = -1
        y3 = -1
        if grid[i][j] != ".":
            x1 = i
            y1 = j
        else: break
        try:
            if grid[i+1][j] != ".":
                x2 = i+1
                y2 = j
        except:
            pass
        try:
            if grid[i][j+1] != ".":
                x3 = i
                y3 = j+1
        except:
            pass
        print(x1, y1, x2, y2, x3, y3) # Three coordinates: a node, its right neighbor, its bottom neighbor
