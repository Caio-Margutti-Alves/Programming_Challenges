table = [[0 for x in range(8)] for x in range(8)]
movements = [[2,1],[-2,1],[2,-1],[-2,-1],[1,2],[-1,2],[1,-2],[-1,-2]]
cur = [0,0]
found = False
count = 0

def print_table():
	for i in range(0,8):
		print (table[i])

def knight_tour():
	global cur
	global count

	cur[0] = int(input("Inital Row: "))
	cur[1] = int(input("Inital Colunm: "))

	backtracking()

#def table_complete():
#	for i in table:
#		for j in i:
#			if table[i][j] == 0:	return False
#	return True

def backtracking():
	global table
	global count
	global found
	global cur 

	if found == True: return
	else:
		if count == 64: found = True
		else:
			tried_movements = [i for i in range(0,8)]
			x = 0
			y = 0
			for m in tried_movements:
				x = cur[0] + movements[m][0]
				y = cur[1] + movements[m][1]
				print (x)
				print (y)
				next_pos = table[x][y]
				print (next_pos)
				if (0 <= x <= 8 and 0 <= y <= 8 and next_pos == 0):
							cur = next_pos
							count += 1
							table[x][y] = count
							backtracking()
							if count == 64: 
								found = True
								return
							cur[0] -= movements[m][0]
							cur[1] -= movements[m][1]
							count -= 1
							table[cur[0]][cur[1]] = 0
			


knight_tour()
print_table()
