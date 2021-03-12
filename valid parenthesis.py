# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
# iterate throught the String use stack to store opening brakcs while popping check with curr char
# if bracket is closing and stack is empty or does not match with curren char return False
class Solution:
    def isValid(self, s: str) -> bool:
        if s==None or len(s) == 0: return 
        stack = []
        
        for i in s:
            if i == "(": stack.append(")")
            elif i == "[": stack.append("]")
            elif i == "{": stack.append("}")
            elif len(stack) == 0 or i != stack.pop(): return False
            
        if len(stack)==0:
            return True
        return False
        