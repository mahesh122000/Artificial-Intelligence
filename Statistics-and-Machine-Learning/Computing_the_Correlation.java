import math
n=int(input())
m=[]
p=[]
c=[]
for i in range(n):
    a,b,d=map(int,input().split())
    m.append(a)
    p.append(b)
    c.append(d)
mx=sum(m)
px=sum(p)
cx=sum(c)
m2=sum([i*i for i in m])
p2=sum([i*i for i in p])
c2=sum([i*i for i in c])
mp=sum([i*j for (i,j) in zip(m,p)])
pc=sum([i*j for (i,j) in zip(p,c)])
cm=sum([i*j for (i,j) in zip(c,m)])
val1=(n*mp-mx*px)/((math.sqrt(n*m2-mx*mx))*(math.sqrt(n*p2-px*px)))
val2=(n*pc-px*cx)/((math.sqrt(n*p2-px*px))*(math.sqrt(n*c2-cx*cx)))
val3=(n*cm-cx*mx)/((math.sqrt(n*c2-cx*cx))*(math.sqrt(n*m2-mx*mx)))
print(round(val1,2))
print(round(val2,2))
print(round(val3,2))