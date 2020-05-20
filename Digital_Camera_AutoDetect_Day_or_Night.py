import numpy as np
import sys
l=[]
for line in sys.stdin:
    p=line.split(" ")
    for q in p:
        rgb=q.split(',')
        gray=0.07*float(rgb[0])+0.72*float(rgb[1])+0.21*float(rgb[2])
        l.append(gray)
h=np.histogram(l,256,[0,256],density=True)[0]
if(h[:60].sum()>0.5):
    print("night")
else:
    print("day")
    