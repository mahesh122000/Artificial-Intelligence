p=[15,12,8,8,7,7,7,6,5,3]
h=[10,25,17,11,13,17,20,13,9,15]
n = len(p)
x_y = sum([i*j for (i,j) in zip(p,h)])
x = sum(p)
y = sum(h)
x_x = sum([i**2 for i in p])
a = (y*x_x - x*x_y) / (n*x_x - x**2)
b = (n*x_y - x*y) / (n*x_x - x**2)
ans = a + b*10
print(round(ans,1))