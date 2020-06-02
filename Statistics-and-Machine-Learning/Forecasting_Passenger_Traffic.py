import numpy as np
from scipy import interpolate
n=int(input())
train_x=[]
train_y=[]
test_x=[]
test_y=[]
for i in range(n):
    s=input().split('\t')
    train_x.append(i)
    train_y.append(float(s[1]))
train_x=np.array(train_x)
train_y=np.array(train_y)
for i in range(n,n+12):
    test_x.append(i);
us=interpolate.UnivariateSpline(train_x,train_y,s=2)
for i in test_x:
    print(us(i))