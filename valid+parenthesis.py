#Time => O(n)
#Space => O(n)

class Solution:
    def isValid(self, s: str) -> bool:
        ch_stack=[]
        
        for i in s:
            if i=='(' or i=="[" or i=="{":
                ch_stack.append(i)
                
            else:
                if i==")":
                    if(len(ch_stack)==0 or ch_stack.pop() != '('):
                        return False
                elif i=="]":
                    if(len(ch_stack)==0 or ch_stack.pop() != '['):
                        return False
                elif i=="}":
                    if(len(ch_stack)==0 or ch_stack.pop() != '{'):
                        return False
        
        return True if len(ch_stack)==0 else False