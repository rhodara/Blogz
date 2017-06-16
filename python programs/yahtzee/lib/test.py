def testEqual(actual, expected):
    if type(expected) == type(1):
        # they're integers, so check if exactly the same
        if actual == expected:
            print('Pass')
            return True
    elif type(expected) == type(1.11):
        # a float is expected, so just check if it's very close, to allow for
        # rounding errors
        if abs(actual-expected) < 0.00001:
            print('Pass')
            return True
    else:
        # check if they are equal
        if actual == expected:
            print('Pass')
            return True
    print('Test Failed: expected ' + str(expected) + ' but got ' + str(actual))
    return False
