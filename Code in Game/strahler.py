#!/usr/bin/python3

from collections import deque

s1 = input()

for f in range(int(s1)):
	s2 = input()
	k,m,p = (int(x) for x in s2.split())

	g = [[0 for x in range(0,m)] for x in range(0,m)]
	gt = [[0 for x in range(0,m)] for x in range(0,m)]
	#g_trans = [[0 for x in range(0,m)] for x in range(0,m)]
	order = [0 for x in range(0,m)]
	visited = [0 for x in range(0,m)]

	#print(k,m,p)

	for j in range(p):
		s3 = input()
		n,e = (int(x) for x in  s3.split())

		g[n-1][e-1] = 1
		gt[e-1][n-1] = 1


	for i in range(len(g)):
		for j in range(len(g[i])):
			if g[i][j] !=0 : order[j]+=1


	queue = []

	for i in range(len(order)):
		if order[i] == 0: 
			visited[i] =  1
			queue.append(i)

	#print (queue)
	#print (visited)

	while queue:
		best = 1
		node = queue.pop(0)
		#print("Node:", node)
		for i in gt[node]:
			#print("i:",i)
			if i == 1:
				 if visited[node] > best:
				 	best = order[node]
				 elif visited[node] == best:
				 	best += 1
		visited[i] = best
		#print("Best:",best)
		for i in range(len(g[node])):
			if g[node][i] != 0:
				if visited[i] == 0:
					visited[i] = best
					queue.append(i)

	order.sort()		

	#print (order)
	#print (visited)
	print(f+1, order[len(order)-1])