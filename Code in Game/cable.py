import sys, math, operator

# Auto-generated code below aims at helping you parse
# the standard input according to the problem statement.

houses = []
cable = 0

def print_houses():
    for i in houses:
        print(i, file = sys.stderr)

N = int(input())
for i in range(N):
    houses.append([int(j) for j in input().split()])

houses.sort(key = operator.itemgetter(0, 1))

print_houses()

y_count = 0

#for i in range(0, len(houses)):
    #y_count+= houses[i][1]

max = -1
n = -1

for i in houses:
    at = houses.count(i[1])
    if at >= max:
        max = at
        n = i[1]
        
y_count = n

if max <= 1:    
    y_count = round(y_count/len(houses))

print("Y medium:",y_count, file = sys.stderr)
print("Y max:",max, file = sys.stderr)

'''for i in range(0, len(houses)-1):
    cable += abs(int(houses[i][1]) - int(houses[i+1][1]))
    print("Y cable:",cable, file = sys.stderr)'''
    
for i in range(0, len(houses)):
    cable += abs(houses[i][1] - y_count)
    print("Y cable:",cable, file = sys.stderr)

cable += houses[len(houses)-1][0] - houses[0][0] 

print("X cable:", houses[len(houses)-1][0] - houses[0][0], file = sys.stderr)

print(int(cable))s