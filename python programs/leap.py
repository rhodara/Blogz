
#chapt 6 graded assignment
def isLeap(year):
    return ((year%4==0 and (year%100 !=0)) or ((year%100 == 0) and (year % 400 ==0)))
print (isLeap(1944))
