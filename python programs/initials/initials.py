def get_initials(fullname):
    listOfNames = fullname.split()
    initials = ""
    for name in listOfNames:
         initials = initials + name[0].upper()
    return initials


def main():
    name = input("enter you name: ")
    print(get_initials(name))


if __name__ == '__main__':
    main()
        