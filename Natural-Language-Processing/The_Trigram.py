from collections import Counter
from functools import reduce
from operator import iconcat
import sys

def convert(text):
    return text.lower().split('.')

def getTrigrams(sentence):
    words = sentence.split()
    return [" ".join(words[i:i+3]) for i in range(len(words)-2)]

if __name__ == '__main__':
    text = sys.stdin.read()
    trigrams = Counter(reduce(iconcat, map(getTrigrams, convert(text)), []))
    print(max(trigrams, key=trigrams.get))