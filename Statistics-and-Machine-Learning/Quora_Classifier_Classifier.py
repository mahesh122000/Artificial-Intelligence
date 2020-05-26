import numpy as np
from sklearn.ensemble import ExtraTreesClassifier
from sklearn.ensemble import RandomForestClassifier
from sklearn.preprocessing import PolynomialFeatures


train_x=[]
train_y=[]
n,m=map(int,input().split())
for _ in range(n):
    line=input().split(' ')
    train_y.append(int(line[1]))
    l=[]
    for i in range(2,m+2):
        p=line[i].split(':')
        l.append(float(p[1]))
    train_x.append(l)

train_x=np.array(train_x)
train_y=np.array(train_y)
pf=PolynomialFeatures()
'''
etc=ExtraTreesClassifier()
etc.fit(train_x,train_y)
'''
train_x=pf.fit_transform(train_x)
rfc=RandomForestClassifier(criterion="entropy",n_estimators=13)
rfc.fit(train_x,train_y)

n=int(input())
test_x=[]
label=[]
for _ in range(n):
    line=input().split(' ')
    label.append(line[0])
    l=[]
    for i in range(1,m+1):
        p=line[i].split(':')
        l.append(float(p[1]))
    test_x.append(l)

'''
predict_y=etc.predict(test_x)
'''
test_x=np.array(test_x)
test_x=pf.fit_transform(test_x)
predict_y=rfc.predict(test_x)
for i in range(len(label)):
    if(predict_y[i]>0):
        print(label[i]+" +1")
    else:
        print(label[i]+" -1")

