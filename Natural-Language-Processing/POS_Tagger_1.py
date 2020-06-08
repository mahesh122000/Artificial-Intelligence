import nltk
from nltk.tag import pos_tag,map_tag
nltk.download('punkt')
nltk.download('averaged_perceptron_tagger')
nltk.download('universal_tagset')

sentence = '''The planet Jupiter and its moons are in effect a minisolar system,
and Jupiter itself is often called a star that never caught fire.'''

tokens=nltk.word_tokenize(sentence)
pos_tagged=nltk.pos_tag(tokens)

for ttuple in pos_tagged:
    print("{0}/{1}".format(ttuple[0],ttuple[1]), end=' ')
'''
Output:

The/DT planet/NN Jupiter/NNP and/CC its/PPS moons/NNS are/VBP in/IN effect/NN a/DT minisolar/JJ system/NN ,/, and/CC Jupiter/NNP itself/PRP is/VBZ often/RB called/VBN a/DT star/NN that/IN never/RB caught/VBN fire/NN ./.
'''