def formerlySquare(x, exp):
    runningtotal = 0
    base = x
    for each in range(exp - 1):  # range 1 < than exp as
        for counter in range(x):
            runningtotal += base # runningtotal accumulate on the inner loop
    base = runningtotal      # base is replaced by the cumulative total of the inner loop before the outer loop iterates again
    runningtotal = 0         # reset running total for starting next outer loop iteration

    return base

print(formerlySquare(2,1))
print(formerlySquare(2,3))
print(formerlySquare(2,4))
print(formerlySquare(5,3))
print(formerlySquare(2, 8))
print(formerlySquare(10,2))
print(formerlySquare(10, 3))
print(formerlySquare(6, 2))
