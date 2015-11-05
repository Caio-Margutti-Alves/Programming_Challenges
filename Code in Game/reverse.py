#!/usr/bin/python3

s = input()

a = [chr(i) for i in range(ord("A"),ord("Z")+1)]
a.append("_")
a.append(".")
#print (a)

while s != "0":
	w = s.split()[1][::-1]
	rot = int(s.split()[0])

	b = []

	if rot < 26:
		b = [chr(i) for i in range(ord("A")+rot,ord("Z")+1)]
		b.append("_")
		b.append(".")
		b.extend([chr(i) for i in range(ord("A"),ord("A")+rot+1)])
	elif rot == 26:
		b.append("_")
		b.append(".")
		b.extend([chr(i) for i in range(ord("A"),ord("Z")+1)])
	else:
		b.append(".")
		b.extend([chr(i) for i in range(ord("A"),ord("Z")+1)])
		b.append("_")

	#print (b)

	ans = ""
	for i in w:
		ans += b[(a.index(i))]
	print(ans)
	s = input()