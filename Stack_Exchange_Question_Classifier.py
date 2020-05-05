import json
from sklearn.svm import LinearSVC 
from sklearn.feature_extraction.text import HashingVectorizer
hv=HashingVectorizer(stop_words='english')
svm=LinearSVC()
train_features=[]
train_label=[]
f=open('training.json')
for i in range(int(f.readline())):
    data=json.loads(f.readline())
    train_features.append(data['question']+"\r\n"+data['excerpt'])
    train_label.append(data['topic'])
f.close()
train_data=hv.fit_transform(train_features)
svm.fit(train_data,train_label)
test_data=[]
for i in range(int(input())):
    test=json.loads(input())
    test_data.append(test['question']+"\r\n"+test['excerpt'])
test_data = hv.transform(test_data)
test_label=svm.predict(test_data)
for e in test_label: print(e)
