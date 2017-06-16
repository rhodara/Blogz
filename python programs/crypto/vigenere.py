#vigenere.py

from helpers import alphabet_position, rotate_character
def getVigRotation(keyword,indexV):
    return alphabet_position(keyword[indexV])
    
def encryptV(text, keyWord):
     encryptedPhrase=""
     indexV=0
     for ch in text:
         if not(ch.isalpha()):
            encryptedPhrase+=ch
         else:            
            rot = getVigRotation(keyWord,indexV)
            encryptedPhrase+=rotate_character(ch, rot)
            indexV+=1
            if indexV>=len(keyWord):
                indexV=0
     return encryptedPhrase
            
def main():
    phrase = str(input("enter a phrase: "))
    word = str(input("enter a key word: "))
    print (encryptV(phrase,word))

if __name__ == "__main__":
    main()


