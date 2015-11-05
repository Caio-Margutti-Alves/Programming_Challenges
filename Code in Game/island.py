#!/usr/bin/python3

s = input()

for i in range(int(s)):
	s = input()
	num = [int(j) for j in s.split()[1:len(s):]]
	line = int(s.split()[0])
	islands = 0 

	#print (num)

	for i in range(13, 0, -1): # De 13 a 0 - tamanhos ilhas
		#print ("I",i)
		for k in range(0,14-i): #Deslocamento
			#print ("K",k)
			#print ("k",k, "14-i",14-i)
			for x in range(k+1,k+1+i):
				#print ("i",i,"k",k,"x",x,"k+1+i",k+1+i)
				#print (num[k],">", num[x], "<",  num[k+1+i])
				if num[x] <= num[k] or num[x] <= num[k+1+i] or num[x]==0: 
					#print ("Break")
					break
			else: 
				#print (x)
				islands += 1
				#print ("islands", islands)

	print (line, islands)
