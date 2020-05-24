import pandas as pd
from sklearn.linear_model import LinearRegression

v=float(input())

data=pd.read_csv('trainingdata.txt',sep=',')
data.columns=["ChargTime", "LifeTime"]
dataLinear=data[data.LifeTime<8]
X=dataLinear.iloc[:,[0]].values
Y=dataLinear.iloc[:,[1]].values

if (v>4):
    print(8)
else:
    lr=LinearRegression()
    lr.fit(X,Y)
    w=lr.predict([[v]])
    print(round(w[0][0],2))
