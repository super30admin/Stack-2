class Solution:
    def isValid(self, s: str) -> bool:
        #Time: O(N)
        #Space: O(N)
        if s=='':
            return True
        stack = []
        for i in s:
            if i == '(' or i=='['  or i== '{':
                stack.append(i)
            else:
                if stack==[]:
                    return False
                else:
                    if i==')':
                        if stack[-1]!='(':
                            return False
                        stack.pop()
                    elif i==']':
                        if stack[-1]!='[':
                            return False
                        stack.pop()
                    else:
                        if stack[-1]!='{':
                            return False
                        stack.pop()
        if stack!=[]:
            return False
        return True