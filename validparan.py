class Solution:
    # TC-O(n),SC-O(n)
    def isValid(self, s: str) -> bool:
        dict = {'}':'{',')':'(',']':'['}
        stack=[]
        for i in s:
            if i in dict:
                if len(stack)>0 and stack[-1]==dict[i]:
                    stack.pop()
                else:
                    stack.append(i)
            else:
                stack.append(i)
            print(stack)
        if len(stack)==0:
            return True
        else:
            return False

        