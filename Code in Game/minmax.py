max = max(vs)
min = min(vs)

i_max = vs.index(max)
i_min = vs.index(min
)

while vs.find(max) > vs.find(min):
    vs.pop(ma
    max = max(vs)
    min = min(vs)
    
print(min-max, file=sys.stderr)



-------------------

i_max = vs.index(max_n)
i_min = vs.index(min_n)

print(vs, file = sys.stderr)

while i_max > i_min or i_max == len(vs) -1:
    print(i_max, file = sys.stderr)
    print(i_min, file = sys.stderr)
    vs.pop(i_max)
    if not vs:
        break
    max_n = int(max(vs))
    i_max = vs.index(max_n)

if vs:
    min_n = int(min(vs[i_max:len(vs)]))
    print(min_n-max_n)
else:
    print(0)