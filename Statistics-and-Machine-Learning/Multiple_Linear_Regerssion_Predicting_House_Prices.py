from sklearn.linear_model import LinearRegression
import numpy as np
f,n=map(int,input().split())
data=[]
for i in range(n):
    data.append(list(map(float,input().split())))
data=np.array(data)
x=data[:,0:f]
y=data[:,-1]
lr=LinearRegression()
lr.fit(x,y)
m=int(input())
test=[]
for i in range(m):
    test.append(list(map(float,input().split())))
test=np.array(test)
y_predicted=lr.predict(test)
print(*y_predicted,sep='\n')
