import sys
import pandas as pd
from sklearn.linear_model import LinearRegression
from sklearn.ensemble import GradientBoostingRegressor
df = []
n=int(input())
for i in range(n+1):
    data = sys.stdin.readline().strip().split('\t')
    data = list(filter(None, data))
    df.append([str(c) for c in data])
column = df.pop(0)
df = pd.DataFrame(df, columns=column)
df1 = df[df['tmax'].str.contains('Missing')]
test1= df1.loc[:,df1.columns!='tmax']
df1 = df1.append(df[df['tmin'].str.contains('Missing')], ignore_index=True)
test2 = df[df['tmin'].str.contains('Missing')]
test2 = test2.loc[:,test2.columns!='tmin']
df = pd.merge(df,df1, indicator=True, how='outer').query('_merge=="left_only"').drop('_merge', axis=1)
df = df.reset_index(drop=True)
months = {'January':1, 'February':2, 'March':3, 'April':4, 'May':5, 'June':6,
     'July':7, 'August':8, 'September':9, 'October':10, 'November':11,'December':12}
df.month = df.month.map(months)
test1.month = test1.month.map(months)
test2.month = test2.month.map(months) 
train = df
ans=[]
'''model1 = LinearRegression(normalize=True)
model1.fit(train.loc[:,train.columns != 'tmax'],train.loc[:,'tmax'])

for i,j in enumerate(model1.predict(test1)):
    ans.append((test1.index[i],round(j,1)))

model2 = LinearRegression(normalize=True)
model2.fit(train.loc[:,train.columns != 'tmin'],train.loc[:,'tmin'])

for i,j in enumerate(model2.predict(test2)):
    ans.append((test2.index[i],round(j,1)))'''

clf1 = GradientBoostingRegressor(n_estimators=100, learning_rate=0.7, max_depth=5)
clf1.fit(train.loc[:,train.columns != 'tmax'],train.loc[:,'tmax'])
for i,j in enumerate(clf1.predict(test1)):
    ans.append((test1.index[i],round(j,1)))    
clf2 = GradientBoostingRegressor(n_estimators=100, learning_rate=0.7, max_depth=5)
clf2.fit(train.loc[:,train.columns != 'tmin'],train.loc[:,'tmin'])
for i,j in enumerate(clf2.predict(test2)):
    ans.append((test2.index[i],round(j,1)))
    
ans.sort()
for k in range(len(ans)):
    print(ans[k][1])