import pandas as pd
import json
from sklearn.feature_selection import VarianceThreshold
from sklearn.ensemble import ExtraTreesClassifier

subject_list = ['Physics', 'Chemistry', 'ComputerScience', 'Hindi', 'Biology', 'PhysicalEducation', 'Economics', 'Accountancy', 'BusinessStudies', 'English', 'Mathematics']
train=[]
with open('training.json') as f:
    i=f.readline()
    for line in f.readlines():
        features=json.loads(line)
        del features['serial']
        for sub in subject_list:
            if sub not in features:
                features[sub]=0
        train.append(features)

train_x=pd.DataFrame(train,columns=subject_list)
train_y=train_x['Mathematics'].values
del train_x['Mathematics']
train_x=train_x.values
vt=VarianceThreshold()
train_x=vt.fit_transform(train_x)
etc=ExtraTreesClassifier()
etc.fit(train_x,train_y)

n=int(input())
test=[]
for _ in range(n):
    l=input()
    features=json.loads(l)
    del features['serial']
    for sub in subject_list:
        if sub not in features:
            features[sub]=0
    test.append(features)

test_x=pd.DataFrame(test,columns=subject_list[:-1]).values
test_x=vt.fit_transform(test_x)
predict_y=etc.predict(test_x)
for y in predict_y:
    print(y)
