import math
import numpy as np
import re


def val(vec):
    temp = 0
    for var in vec:
        temp += var ** 2
    return math.sqrt(temp)


def cosine_similarity(doc1, doc2, Docs):
    vec1 = []
    vec2 = []
    words = list(set((doc1 + ' ' + doc2).split()))
    for word in words:
        t = tf(word, doc1)
        id = idf(word, Docs)
        vec1.append(t * id)
    for word in words:
        t = tf(word, doc2)
        id = idf(word, Docs)
        vec2.append(t * id)

    return np.dot(vec1, vec2) / (val(vec1)* val(vec2))


def tf(term, doc):
    dict_doc = {}
    for word in doc.split():
        dict_doc[word] = doc.count(word)
    return doc.count(term) / (max(dict_doc.values()))



def idf(term, d):
    count = 0
    for doc in d:
        if doc.count(term) > 0:
            count += 1
    return math.log10(1 + (len(d) - count) / (count + 1))


def punctuation_remove(t, punctuations):
    for p in punctuations:
        t = t.replace(p, ' ')
    return t


def key_word_remove(t, key_words):
    for w in key_words:
        t = t.replace(w, ' ')
    return t


punctuations = [',', ':', ';', '/', '(', ')', '[', ']', '-', '_', '"', "'", '!', '?', '–']

key_words = ['which ', 'what ', 'when ', 'where ', 'who ', 'how ', 'whose ', 'whom ', 'why ', 'while', ' is ', ' are ',' am ', ' have ', ' has ', ' do ', ' to ', ' had ', ' of ', ' the ', ' that ', ' this ',' they ', ' he ', ' she ', ' i ', ' Are ', ' and ']

wiki = str(input())
questions = []
for i in range(0, 5):
    questions.append(str(input()).lower())

answers = str(input()).lower().split(';')


wiki = wiki.replace('.', ' . ')
wiki = punctuation_remove(wiki, punctuations)
wiki = key_word_remove(wiki, key_words)
wiki = " ".join(wiki.lower().split())
sentences = wiki.split('.')
for sentence in sentences:
    if len(sentence) == 0:
        sentences.remove(sentence)
Doc = wiki

for i in range(len(questions)):
    for word in key_words:
        questions[i] = questions[i].replace(word, ' ')
    for word in punctuations:
        questions[i] = questions[i].replace(word, ' ')
    Doc.join(' . ' + questions[i])
Doc = Doc.split('.')

count = 0
for question in questions:
    question_sentences_similarity = []
    for sentence in sentences:
        question_sentences_similarity.append((question, sentence, cosine_similarity(question, sentence, Doc)))

    question_sentences_similarity.sort(key=lambda x: x[2], reverse=True)

    best_sentence = question_sentences_similarity[0][1]

    answers_sentence_similarity = []

    for answer in answers:
        answers_sentence_similarity.append((answer, best_sentence, cosine_similarity(answer, best_sentence, Doc)))

    answers_sentence_similarity.sort(key=lambda x: x[2], reverse=True)
    print(answers_sentence_similarity[0][0])
    count += 1
