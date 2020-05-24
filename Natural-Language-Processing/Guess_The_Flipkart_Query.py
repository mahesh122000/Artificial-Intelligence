import re
import numpy as np
from sklearn.svm import LinearSVC
from sklearn.feature_extraction.text import CountVectorizer
from sklearn.feature_extraction.text import TfidfTransformer,TfidfVectorizer
from sklearn.pipeline import Pipeline

def words(text):
    return re.findall(r'(?:[a-zA-Z]+[a-zA-Z\'\-]?[a-zA-Z]|[a-zA-Z]+)',text)

train_x=[]
train_y=[]

i=0
with open('training.txt') as f:
    for line in f:
        i+=1
        if i==1:
            continue
        x=[t for t in line.rstrip().split('\t')]
        sentence=" ".join(word for word in words(x[0]))
        train_x.append(sentence)
        train_y.append(x[1])

train_x=np.array(train_x)
train_y=np.array(train_y)

pipeline=Pipeline([('vect',CountVectorizer()),('tfidf',TfidfTransformer()),('clf',LinearSVC())])
pipeline.fit(train_x,train_y)

test_x=[]
for i in range(int(input())):
    x=input().rstrip()
    sentence=" ".join(word for word in words(x))
    test_x.append(sentence)

test_x=np.array(test_x)
predict_y=pipeline.predict(test_x)

for val in predict_y:
    print(val)
