#E(x^2)=variance(x)+E(X)^2
#but variance is E(x) in poisson distribution
x=0.88
y=1.55
ex2=160+40*(x+x**2)
ey2=128+40*(y+y**2)
print(ex2)
print(ey2)