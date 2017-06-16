
def factorsList(n):
    factors = []
    for i in range (1, n+1):
        if n % i == 0:
            factors.append(i)
    return factors;



def main():
    factors_dictionary = {}
    num = input("enter a number")
    num=12
    for number in range (1, num+1):
        factors_dictionary[number]= factorsList(number)
    print (factors_dictionary)
        
main()