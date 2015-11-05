#!/usr/bin/python3

try:
    # for Python2
    from Tkinter import *   ## notice capitalized T in Tkinter 
except ImportError:
    # for Python3
    from tkinter import *   ## notice here too

root = Tk()
canvas = Canvas(root, bg="blue", height=250, width=300)
count  = 0

def draw_body():

	canvas.delete("all")

	x0 = 90
	x1 = 140
	y0 = 5
	y1 = 50

	eye1 = canvas.create_oval(x0, y0, x1, y1, fill="red")
	eyeball1 = canvas.create_oval(x0+20, y0, x1-20, y1, fill="black")
	eye2 = canvas.create_oval(x0 + 60, y0, x1+60, y1, fill="red")
	eyeball1 = canvas.create_oval(x0 + 80, y0, x1 +40, y1, fill="black")

	line1 = canvas.create_line(x0+25, y1, x0+25, 115, fill="red")
	line2 = canvas.create_line(x0+85, y1, x0+85, 115, fill="red")

	coord1 = x0, 50, x1+60, 150
	mouth = canvas.create_arc(coord1, start=180, extent=180, fill="red")

	coord2 = x0+20, 100, x1+40, 180
	tongue = canvas.create_arc(coord2, start=0, extent=180, fill="black")

	leg1 = canvas.create_line(x0+30, 142, x0+20, 190, fill="red")
	leg2 = canvas.create_line(x0+45, 141, x0+40, 190, fill="red")
	leg3 = canvas.create_line(x0+55, 140, x0+55, 190, fill="red")
	leg4 = canvas.create_line(x0+65, 140, x0+65, 190, fill="red")
	leg5 = canvas.create_line(x0+75, 141, x0+80, 190, fill="red")
	leg6 = canvas.create_line(x0+85, 142, x0+95, 190, fill="red")

	sand = canvas.create_rectangle(0, 190, 300, 350, fill="khaki")

	dance()

def dance():

	global count
	
	x0 = 90
	x1 = 140
	y0 = 5
	y1 = 50

	if count % 2 ==0:

		arm1 = canvas.create_line(x0-30, 150, x0, 100, fill="red")
		arm2 = canvas.create_line(x0+110, 100, x1+100, 150, fill="red")

		coord1 = x1+80, 150, x1+130, 180
		coord2 = x1+80, 150, x1+130, 180
		claw1 = canvas.create_arc(coord1, start=80, extent=180, fill="red")
		claw2 = canvas.create_arc(coord2, start=285, extent=180, fill="red")

		coord1 = x0-20, 150, x0-70, 180
		coord2 = x0-20, 150, x0-70, 180
		claw3 = canvas.create_arc(coord1, start=310, extent=180, fill="red")
		claw4 = canvas.create_arc(coord2, start=60, extent=180, fill="red")

	else:

		arm1 = canvas.create_line(x0-30, 80, x0, 100, fill="red")
		arm2 = canvas.create_line(x0+110, 100, x1+100, 80, fill="red")

		coord1 = x1+80, 60, x1+130, 90
		coord2 = x1+80, 60, x1+130, 90
		claw1 = canvas.create_arc(coord1, start=180, extent=180, fill="red")
		claw2 = canvas.create_arc(coord2, start=50, extent=180, fill="red")

		coord1 = x0-20, 60, x0-70, 90
		coord2 = x0-20, 60, x0-70, 90
		claw3 = canvas.create_arc(coord1, start=210, extent=180, fill="red")
		claw4 = canvas.create_arc(coord2, start=320, extent=180, fill="red")


	if count != 0: v.set("Hi, I am " + input_text.get() + ", the crab!")

	canvas.pack()
	count+=1

draw_body()

button = Button(root, text ="Dance Crab!", command = draw_body)

v = StringVar()
name = Label(root, textvariable=v, text="Give me a name")

input_text = Entry(root)

name.pack()
input_text.pack()
canvas.pack()
button.pack()

root.mainloop()