import re
from collections import Counter
from  string import ascii_lowercase

def convert(text):
    return re.findall(r'(?:[a-z]+[a-z\'\-]?[a-z]|[a-z]+)',text.lower())

def initialize():
    dictonary=Counter(convert(open('corpus.txt').read()))
    return dictonary

def add_characters(word):
    l=[]
    for i in ascii_lowercase:
        for j in range(len(word)):
            l.append(word[:j]+i+word[j:])
    return l

def sub_characters(word):
    l=[]
    for i in ascii_lowercase:
        for j in range(len(word)):
            l.append(word[:j]+i+word[j+1:])
    return l

def del_characters(word):
    l=[]
    for i in range(len(word)):
            l.append(word[:i-1]+word[i+1:])
    return l

def swap_characters(word):
    l=[]
    for i in range(1,len(word)):
        l.append(word[:i-1]+word[i]+word[i-1]+word[i+1:])
    return l

def possible_words(word):
    return add_characters(word)+sub_characters(word)+del_characters(word)+swap_characters(word)

def valueOf(word):
    return Dictonary[word]

def corrected_word(word):
    possible_list=set(possible_words(word)).intersection(set(Dictonary))
    if(len(possible_list)>0):
        most_probable=max(possible_list,key=valueOf)
        return sorted([w for w in possible_list if Dictonary[w]==Dictonary[most_probable]])[0]
    return (word)

Dictonary=initialize()
for _ in range(int(input())):
    word=input().strip().lower()
    if word in Dictonary:
        print(word)
    else:
        print(corrected_word(word))

