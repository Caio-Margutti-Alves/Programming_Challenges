#!/usr/bin/python3

s1 = input()

while s1 != "0":
	n,t = (int(x) for x in s1.split())
	players = [0 for x in range(n)]

	big = 0
	index = 0
	best = 0
		
	while True:

		base = int(t/len(players))
		rest = t % len(players)

		#print("Base:",base)
		#print("Rest:",rest)
		#print("Length:",len(players))

		index = best

		for i in range(len(players)):
			ex = (index + i) % len(players)
			#print("Index:", ex)
			players[ex] += base
			if rest > 0:
				players[ex] += 1
				rest -= 1
				if rest == 0:
					rest-=1
					best = (index + i) % len(players)

		#for i in players:
		#	print("Player:",i)

		players.pop(best)
		best = best % len(players)
		#print("best",best)
	
		big = max(players)

		#print("Count: ",players.count(big))
		#print("n: ",n)
		#print("Big:", big)

		if players.count(big) == len(players):
			break

	print (len(players), big)
	s1 = input()