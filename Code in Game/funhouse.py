#!/usr/bin/python3

def calc_traj():
	pass


s = input()

while s != "0 0":
	w,h = (int(x) for x in s.split())
	ini = []
	tab = []
	for i in range(h):
		s = input()

		tab.append(str(s).split())

		if "*" in s: ini = [i,s.find("*")]


		print (ini)

	for i in tab:
		print (str(i))

	s = input()