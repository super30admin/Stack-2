class Solution:
    # T.C. = O(n)
    # S.C. = O(1)
    def isValid(self, s: str) -> bool:
        stack = list()
        #mapping closing elements to thier opening ones
        closeToOpen = { ')':'(', '}':'{', ']':'['}
        for char in s:
            #if current character is closing character
            if char in closeToOpen:
                #if stack is non-empty and last character is the opening for current closing
                if stack and stack[-1] == closeToOpen[char]:
                    stack.pop()
                else:
                    #we cant append a closing character if the stack is empty or last opening
                    #doesnt match current closing
                    return False
            #opening character
            else:
                stack.append(char)

        #if the stack is empty then we return True, else False
        return True if not stack else False