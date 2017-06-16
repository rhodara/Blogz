def swap(lst, index1,index2):
    temp = lst[index1]
    lst[index1] = lst[index2]
    lst[index2] = temp
# Sorts a list using bubble sort.
def bubble_sort(lst):
    is_sorted = False
    while not is_sorted:
        nswaps = 0
        for x in range (len(lst)-1):
            if lst[x]>lst[x+1]:
                swap(lst,x,x+1)
                
                nswaps+=1
        if (nswaps==0):
            is_sorted = True
    return lst
  
            
print(bubble_sort([2, 3, 5, 4, 1]))