import nltk
from nltk.tag import pos_tag
nltk.download('punkt')
nltk.download('averaged_perceptron_tagger')
nltk.download('universal_tagset')

sentence="People continue to inquire the reason for the race for outer space"
tokens=nltk.word_tokenize(sentence)
pos_tags=nltk.pos_tag(tokens)

for ttuple in pos_tags:
    print("{0}/{1}".format(ttuple[0],ttuple[1]), end=' ')

'''
Output:
People/NNS continue/VBP to/TO inquire/VB the/DT reason/NN for/IN the/DT race/NN for/IN outer/JJ space/NN
'''