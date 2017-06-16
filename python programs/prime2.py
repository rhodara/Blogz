
def is_prime(n):
    if n==2:
        return True
    i=n-1
    while (i>=2):
        if ((n % i)==0):
            return False
        else:
            i=i - 1
    return True

def main():

    if (is_prime(17)):
        print ("yes")
    else:
        print ("no")

main()
