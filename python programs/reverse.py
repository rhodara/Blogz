# this method not working:
# def reverseKeysValue1(fruit_dictionary):
#     newDict = {tuple(v):k for k, v in fruit_dictionary.items()}
#     return newDict

def reverseKeysValue2(fruit_dictionary):
    newDict = {}
    keyList = list(fruit_dictionary.keys())
    valueList = list(fruit_dictionary.values()) 
    newDict=dict(zip(valueList,keyList)) 
    return newDict

def reverseKeysValue3(fruit_dictionary):
    newDict = {}
    keyList = list(fruit_dictionary.keys())
    valueList = list(fruit_dictionary.values()) 
    for i in range (len(keyList)):
        newDict[valueList[i]]=keyList[i]
    return newDict   

def main():
    fruit_dictionary = {'apples':'2','pears':'4','bananas':'6','kiwi':'10'}
    print (fruit_dictionary)
    #print (reverseKeysValue1(fruit_dictionary))
    print (reverseKeysValue2(fruit_dictionary)) 
    print (reverseKeysValue3(fruit_dictionary)) 
          
main()