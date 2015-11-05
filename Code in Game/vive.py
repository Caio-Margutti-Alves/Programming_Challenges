#!/usr/bin/python3

s = input()

while s != "0 0 0 0":
	num = [int(i) for i in s.split()]
	n_num = [int(i) for i in s.split()]
	#print (num)
	#print(n_num)
	count = 0

	while num[0] != num[1] or num[2] != num[3] or num[1] != num[2]:
		for i in range(len(num)):
			#print(i)
			n_num[i] = abs(num[i%4] - num[(i+1)%4])
		
		num = [i for i in n_num]
		#print (n_num)
		#print (num)
		count += 1
	

	print(count)
	s = input()