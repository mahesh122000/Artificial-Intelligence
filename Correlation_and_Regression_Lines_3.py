p=[15,12,8,8,7,7,7,6,5,3]
h=[10,25,17,11,13,17,20,13,9,15]
n = len(p)
xy = sum([i*j for (i,j) in zip(p,h)])
x = sum(p)
y = sum(h)
x2 = sum([i**2 for i in p])
a = (y*x2 - x*xy) / (n*x2 - x**2)
b = (n*xy - x*y) / (n*x2 - x**2)
ans = a + b*10
print(round(ans,1))
