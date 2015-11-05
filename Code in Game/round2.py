#!/usr/bin/python3

s1 = input()

while s1 != "0":
	n,t = (int(x) for x in s1.split())
	players = [0 for x in range(n)]

	base = 0
	rest_ant = 0
	rest_new = -1

	while rest_new != 0 and rest_new != len(players) and len(players) != 1:
		base += int(t/len(players))

		if rest_new != -1: rest_ant = rest_new
		rest_atual = t % len(players)
		rest_new = (rest_ant + rest_atual) % len(players)

		#if rest != 0: base += 1

		players.pop(0)

		print("Rest ant",rest_ant)
		print("Rest atual",rest_atual)
		print("Rest new",rest_new)
		print("Len", len(players))

	print (len(players), base)
	s1 = input()