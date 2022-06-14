#TC: O(n)
#SC: O(n)

class Solution:
    def isValid(self, s: str) -> bool:
        p = {'}':'{', ']':'[', ')':'('}
        stack=[]

        for i in s:
            if i in p.values():     
                stack.append(i)
            if i in p.keys():           
                if (stack==[] or stack[-1] != p[i]):
                    return False
                else:
                    stack.pop()

        return stack==[] 