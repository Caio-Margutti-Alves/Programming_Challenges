#!/usr/bin/python3

import datetime

s = input()

while s != "0 0 0":
	d, s1, s2 = (int(x) for x in s.split())

	#print (d,s1,s2)

	h = 3600

	a1 = d*h/s1
	a2 = d*h/s2


	ans = abs(a1-a2)

	#print (ans)

	ans = str(datetime.timedelta(seconds=ans))
	print (ans)
	
	s = input()