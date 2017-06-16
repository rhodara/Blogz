def stretch(word,i):
    newWord = ''
    for character in word:
       for time in range(i):
           newWord = newWord+character
       #print (newWord)
    return newWord


print (stretch("chihuahua",3))
