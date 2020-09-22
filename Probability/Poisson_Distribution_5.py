import math
def fact(n):
    return 1 if n == 0 else n*fact(n-1)
def poi(k,lam):
    return ((lam**k)*(math.exp(-lam)))/(fact(k))

#1
lam = 1.2
print(round(poi(2,1.2),3))

#2
print(round(poi(0,1.2) + poi(1,1.2) + poi(2,1.2),3))
#or
k = 2; lam = 1.2
round(sum([poi(x,lam) for x in range(0,k+1)]),3)

#3
lam = 12; k = 5 
print(round(poi(k,lam),3))

#4
k = 40; lam = 1.2
print(round(sum([poi(x,lam) for x in range(0,k+1)]),3))