#time complexity: O(n)
#sapce complexity: O(n)
#ran on leetcode; yes
#have a stack to capture the opening braces/bracet. match a closing tag with the corresponding opening tag found on top of the stack
#If closing tags cannot be matched, then return False. After processing the input, the stack should be empty to return True
class Solution:
    def isValid(self, s: str) -> bool:
        stk=[]
        for i in s:
            if(i in ['(','{','[']):
                stk.append(i)
            elif(i==')'):
                if(stk==[] or stk[-1]!='('):
                    return False
                del(stk[-1])
            elif(i==']'):
                if(stk==[] or stk[-1]!='['):
                    return False
                del(stk[-1])
            elif(i=='}'):
                if(stk==[] or stk[-1]!='{'):
                    return False
                del(stk[-1])

        if(stk!=[]):
            return False
        return True
