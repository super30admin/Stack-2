#timie O(N)
#space O(N)
class Solution:
    def isValid(self, s: str) -> bool:
        stack=[]
        for i in s:
            if i=="(" or i=="{" or i=="[":
                stack.append(i)
            else:
                if stack:
                    top=stack[len(stack)-1]
                    if i==")" and top=="(":
                        stack.pop()
                    elif i=="}" and top=="{":
                        stack.pop()
                    elif i=="]" and top=="[":
                        stack.pop()
                    else:
                        return False
                else:
                    return False
        
        if len(stack):
            return False
        return True      
        