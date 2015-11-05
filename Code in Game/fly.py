#!/usr/bin/python3

s = input()

for i in range(int(s)):
	s = input()

	n, d, a, b, f = (float(x) for x in s.split())

	miles = 0.0
	count = 0

	while(round(d,20)>0):
		#print("{0:.2f}".format(round(n,2)))
		x = 0.0
		if(count%2==0):
			x = d/(a+f)
		else:
			x = d/(b+f)

		#print (x)
		#print (f)
		miles += f*x
		d -= ((b*x) + (a*x))
		count+=1

	print (int(n) , "{0:.2f}".format(round(miles,2)))