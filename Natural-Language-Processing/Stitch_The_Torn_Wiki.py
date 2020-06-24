from collections import defaultdict

common_words = ['i','me','my','myself','we','our','ours','ourselves','you','your','yours','yourself','yourselves','he','him','his','himself','she','her','hers',
 'herself','it','its','itself','they','them','their','theirs','themselves','what',
 'which','who','whom','this','that','these','those','am','is','are','was','were',
 'be','been','being','have','has','had','having','do','does','did','doing','a','an',
 'the','and','but','if','or','because','as','until','while','of','at','by','for',
 'with','about','against','between','into','through','during','before','after','above',
 'below','to','from','up','down','in','out','on','off','over','under','again','further',
 'then','once','here','there','when','where','why','how','all','any','both','each',
 'few','more','most','other','some','such','no','nor','not','only','own','same',
 'so','than','too','very','s','t','can','will','just','don','should','now']

def train(sentences):
    global common_words
    features =[]
    for sentence in sentences:
        tokens=sentence.lower().split()
        tokens=[word.strip('''!@#$%^&*()[]{};:"'/<>\\''') for word in tokens if word not in common_words]
        feature=defaultdict(lambda:0)
        for token in tokens:
            feature[token]+=1
        features.append(feature)
    return features

def predict(features,sentences):
    global common_words
    p_features=[]
    for sentence in sentences:
        tokens=sentence.lower().split()
        tokens=[word.strip('''!@#$%^&*()[]{};:"'/<>\\''') for word in tokens if word not in common_words]
        p_features.append(tokens)
    f_list=[]
    for feature in features:
        fp_list=[]
        for p_feature in p_features:
            val=0
            for token in p_feature:
                val+=feature[token]
            fp_list.append(val)
        f_list.append(fp_list)
        print(fp_list.index(max(fp_list)))


a=[]
b=[]

n=int(input())

for _ in range(n):
    a.append(input())

for _ in range(n):
    b.append(input())

features=train(a)
predict(features,b)
    
