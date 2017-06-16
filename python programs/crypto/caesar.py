#caesar.py

from helpers import alphabet_position, rotate_character

def encrypt(text, rot):
     encryptedPhrase=""
     for ch in text:
         if not(ch.isalpha()):
            encryptedPhrase+=ch
         else:
            encryptedPhrase+=rotate_character(ch, rot)
     return encryptedPhrase
            
def main():
    #print(alphabet_position("a"))
    letter = str(input("enter a letter: "))
    rotNum = int(input("enter a rotation number: "))
    print (rotate_character(letter,rotNum))
    phrase = str(input("enter a phrase: "))
    rotNum = int(input("enter a rotation number: "))
    print (encrypt(phrase,rotNum))

if __name__ == "__main__":
    main()


