#!/usr/bin/python3

s = input()

while s != "#":
	#print(s)
	count = 0
	for i in s:
		if i == "1": 
			count +=1 
		elif i == "e": 
			if count%2==0: s = s.replace("e","0")
			else: s = s.replace("e","1")
		elif i == "o": 
			if count%2==0: s = s.replace("o","1")
			else: s = s.replace("o","0")
	print(s)
	s = input()