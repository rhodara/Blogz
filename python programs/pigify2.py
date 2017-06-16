
#-----------------------------------------------------------------
# loop thru sentence and send each word to translateWord
#-----------------------------------------------------------------
def parseSentence(sentence):
    eachWord=""
    pigSentence=""
    i = 0
    sentence = sentence.lower()
    while (len(sentence)>2 and sentence.find(' ')!= -1) :
        spaceIndex = sentence.find(' ')
        eachWord = translateWord(sentence[:spaceIndex])
        pigSentence = pigSentence + " " + eachWord

        sentence = sentence[spaceIndex+1:]
    eachWord = translateWord(sentence[:spaceIndex])
    pigSentence = pigSentence + " " +eachWord
    return pigSentence
#-----------------------------------------------------------------
# translate each word to it's piglatin equivalent
#-----------------------------------------------------------------
def translateWord(word):
       result = ""
       # If the word begins with a vowel,
       # leave unchanged but add yay to end.
       if (beginsWithVowel(word)):
          result = word + "yay";
       else:
          # If the word begins with consonant blend, the first
          # two letters are moved to the end of the word,
          #  and "ay" is appended.
          if (beginsWithBlend(word)):
             result = word[2:len(word)] + word[0:2] + "ay";
          else:
            # If the word begins with one consonant,
            # the first letter is moved to the end of the word,
            # and "ay" is appended.
             result = word[1:len(word)] + word[0] + "ay";

       return result;
#-----------------------------------------------------------------
#  Determines if the specified word begins with a vowel.
#-----------------------------------------------------------------
def beginsWithVowel(word):
    vowels="aeiou"
    firstLetter = word[0];
    if (vowels.find(firstLetter) !=-1):
         return True
    else:
         return False
#-----------------------------------------------------------------
#  Determines if the specified word begins with a consonant blend.
#-----------------------------------------------------------------
def beginsWithBlend (word):
  return ( word[0:2]==("bl") or word[0:2]== ("sc") or
                     word[0:2]== ("br") or word[0:2]== ("sh") or
                     word[0:2]== ("ch") or word[0:2]== ("sk") or
                     word[0:2]== ("cl") or word[0:2]== ("sl") or
                     word[0:2]== ("cr") or word[0:2]== ("sn") or
                     word[0:2]== ("dr") or word[0:2]== ("sm") or
                     word[0:2]== ("dw") or word[0:2]== ("sp") or
                     word[0:2]== ("fl") or word[0:2]== ("sq") or
                     word[0:2]== ("fr") or word[0:2]== ("st") or
                     word[0:2]== ("gl") or word[0:2]== ("sw") or
                     word[0:2]== ("gr") or word[0:2]== ("th") or
                     word[0:2]== ("kl") or word[0:2]== ("tr") or
                     word[0:2]== ("ph") or word[0:2]== ("tw") or
                     word[0:2]== ("pl") or word[0:2]== ("wh") or
                     word[0:2]== ("pr") or word[0:2]== ("wr") )


def main():
    print (parseSentence("London Bridge is falling down"))
main()
