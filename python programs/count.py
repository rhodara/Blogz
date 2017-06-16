
import types
def count_decimals(s):
       """Count the number of numerals after the decimal point
       in a string representing a floating point number."""

       # Check to make sure the input is really a string
       if not (isinstance(s,str)):
           print("error, not a string", s)
           return False

       # and check that it is a well-formed floating point number
       dot_count = s.count(".")   # Note bug in skulpt Python implementation of str.count()
       print("dot count", dot_count)                       # s.count(".") should work as it does in CPython
                                   # See https://github.com/skulpt/skulpt/issues/532
       if (dot_count != 1):
           print("error, malformed float:", s)
           return False

       # Calculate the number of post-dot numerals
       # by finding the position of the dot and
       # using the length of the string. Don't count the dot itself.

       dot_index = s.find(".")
       s = s[dot_index+1:len(s)]
       print (s)
       count = len(s)
      # count = len(s) - dot_index - 1
       return(count)

def main():
    print (count_decimals("12.123456789"))
if __name__ == "__main__":
    main()
