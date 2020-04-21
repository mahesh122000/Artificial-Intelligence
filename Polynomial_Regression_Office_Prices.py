from sklearn.linear_model import LinearRegression
from sklearn.preprocessing import PolynomialFeatures
import numpy as np

f,n=map(int,input().split())
data=[]
for i in range(n):
    data.append(list(map(float,input().split())))
data=np.array(data)
Lr=LinearRegression()
Pf=PolynomialFeatures(f+1,include_bias=False)
x=data[:,:-1]
y=data[:,-1]
Lr.fit(Pf.fit_transform(x),y)
m=int(input())
test=[]
for i in range(m):
    test.append(list(map(float,input().split())))
test=np.array(test)
y_predicted=Lr.predict(Pf.fit_transform(test))
print(*y_predicted,sep='\n')

