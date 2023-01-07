'''
We can make use of stack here
Time Complexity --> O(n)
Space Complexity --> O(n)
'''
class Solution:
    def isValid(self, s: str) -> bool:
        stk = []
        for i in s:
            if i=='(':
                stk.append(')')
            elif i=='{':
                stk.append('}')
            elif i=='[':
                stk.append(']')
            else:
                #a closing braces encountered
                if len(stk)!=0:
                    if stk[-1]!=i:
                        return False
                    else:
                        stk.pop(-1)
                else:
                    return False
        if len(stk)!=0:
            return False
        else:
            return True
