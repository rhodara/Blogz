import time
def is_prime(n):
    if n==2:
        return True
    i=n-1
    while (i>=2):
        if ((n % i)==0):
            return False
        return True

def main():
    def test_for_prime(n, should_be_prime):
        start_time = time.clock()

    if (should_be_prime and is_prime(n)) or
    (not should_be_prime and not is_prime(n)):
        print (str(n),"works", end='')
    else:
        print (str(n),"fails", end='')
    duration = time.clock() - start_time
    print(" in \t{:g} seconds".format(duration))

    print("Testing is_prime()...")
    test_for_prime(1, False)
    test_for_prime(2, True)
    test_for_prime(-1, False)
    test_for_prime(.5, False)
    test_for_prime(13, True)
    test_for_prime(0, False)
    test_for_prime(21, False)
    test_for_prime(15485864, False)
    test_for_prime(15485863, True)

main()
