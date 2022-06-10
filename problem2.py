# Valid Parentheses
# // Time Complexity : O(N)
# // Space Complexity :O(N)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no



class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        paren = {'}':'{', ']':'[', ')':'('}
        stack=[]
        
        for i in s:
            if i in paren.values():     #if its an opening parethesis, then just add to stack
                stack.append(i)
            if i in paren.keys():           #if its a closing, check if its opening bracket is on top of the stack, if its is then pop, if not return False
                if (stack==[] or stack[-1] != paren[i]):
                    return False
                else:
                    stack.pop()
            
        return stack==[]                        #if the stack is empty at the end, then return True else False