def square(x):
    runningtotal = 0
    for counter in range(x):
        for counter in range(x):
           runningtotal = runningtotal + x
           print('num\t',counter )

    return runningtotal

toSquare = 10
squareResult = square(toSquare)
print("The result of", toSquare, "squared is", squareResult)
