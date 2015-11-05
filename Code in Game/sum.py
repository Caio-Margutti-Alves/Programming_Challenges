#!/usr/bin/python3

s = input()

while s != "0":

	i = [int(x) for x in s[1::].split()]
	j = i.count(0)



	i = sorted(i, reverse=True)
	i = i[:len(i)-j:]
	j = [0 for j in range(j)] 

	#print(j)

	#print (i)

	som = 0
	count = 0
	exp = 1

	while i or j:
		a = 0
		if len(j) > len(i):
			j.pop(0)
			j.pop(0)
			count += 2
		else:	
			if len(j) == len(i):
				if len(i) == 2 and len(j)==2:
					a = i.pop(0)
					a += i.pop(0)
					count+=1
				else:
					a = j.pop(0)
			else:
				a = i.pop(0)

			som += a * exp
			count += 1

		
		if count%2 == 0: exp *= 10
			
	print (som)
	s = input()
