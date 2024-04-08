import re

def isPalindrome(self, s: str) -> bool:
    string = re.sub("[^0-9a-zA-Z]", "", s).lower()
    i = 0
    j = len(string) - 1
    while i < j:
        if string[i] != string[j]:
            return False;
        i+=1
        j-=1
    return True;