import math
p=[15,12,8,8,7,7,7,6,5,3]
h=[10,25,17,11,13,17,20,13,9,15]
mx=0.0
my=0.0
xy=0.0
mx2=0.0
my2=0.0
for i in range(len(p)):
    mx+=p[i]
    my+=h[i]
    mx2+=p[i]*p[i]
    my2+=h[i]*h[i]
    xy+=p[i]*h[i]
n=len(p)
r=(n*xy-mx*my)
sx=math.sqrt(n*mx2-mx*mx)
sy=math.sqrt(n*my2-(my*my))
r=r/(sx*sy)
ans=r*(sy/sx)
print(round(ans,3))