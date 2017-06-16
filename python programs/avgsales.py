#compute average of sales per week


def avgbywk(sales):
    sum=0
    numOfWeeks = len(sales)
    averages = [0 for i in range(numOfWeeks)]
    for week in range (numOfWeeks):
        for day in range (7):
            sum = sum + sales[week][day]
            #print(sum)
        averages[week] = sum/7
        sum = 0
    return averages
def main():
    sales = [[1512.30, 1555.72, 1989.77, 2101.33, 1884.45, 1333.33, 1456.23],
[1215.340, 1565.99, 2989.34, 2301.77, 1234.81, 1923.44, 2282.39],
[24.5, 32.1, 21,7, 76.4, 56.4, 100, 90]]
    list = avgbywk(sales)
    print (list)
    
main()