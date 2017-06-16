#vigenere.py


from helpers import alphabet_position, rotate_character
def getVigRotation(keyword,indexV):
    return alphabet_position(keyword[indexV])
    
def encrypt(text, key):
    """receives input as a string (text) and a word as key for incription (key), which is then used to shift characters around to encrypt a message"""
	
    encrypted = ""
    index=0
    for char in text: 
        #use key to get a rotation number 
       
        #from caesar encrypt function
        if char.isalpha() == False: 
            encrypted += char
        else: 
            rot = alphabet_position(key[index])
            encrypted += rotate_char(char, rot)
            if index == len(key):
                index =0
    return encrypted

            
def main():
    phrase = str(input("enter a phrase: "))
    word = str(input("enter a key word: "))
    print (encrypt(phrase,word))

if __name__ == "__main__":
    main()




