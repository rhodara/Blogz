def password_checker(password):
  #A valid password has no spaces,
  #and at least one non-alphabetical character

    contains_non_alpha = False

    for char in password:
        if char == " ":
            return False
        else if not char.isalpha():
            contains_non_alpha = True

    return contains_non_alpha

pw1 = "i <3 makonnen"
print(password_checker(pw1))
# should print False

pw2 = "puzzlesareforfun"
print(password_checker(pw2))
# should print False

pw2 = "puzzlesr4fun"
print(password_checker(pw2))
# should print True
