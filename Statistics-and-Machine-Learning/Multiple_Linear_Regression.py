import numpy as np
from sklearn.linear_model import LinearRegression

m,n=map(int,input().split())
train_x=[]
train_y=[]
for _ in range(n):
    l=list(map(float,input().split()))
    train_x.append(l[0:m])
    train_y.append(l[-1])

train_x=np.array(train_x)
train_y=np.array(train_y)

lr=LinearRegression()
lr.fit(train_x,train_y)

q=int(input())
test_x=[]
for _ in range(q):
    l=list(map(float,input().split()))
    test_x.append(l)

predict_y=lr.predict(test_x)
for y in predict_y:
    print(y)