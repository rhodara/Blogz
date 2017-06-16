def rotate_character(l, num):
    if l.isalpha() and l.islower():
        newchar = (((ord(l)+num - 97) % 26)+97)
        return (newchar)
    else:
        if l.isalpha() and l.isupper():
            newchar = ((((ord(l)+num) - 65) % 26)+65)
            return (newchar)
    
def alphabet_position(h):
    
    h = h.lower()
    n = ord(h)-97
    return n   
