# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
"""
The code goes through the set of parantheses and keeps adding them to the list if they open. For closed ones, it checks if the 
last open parantheses matches the closing one. 
"""

class Solution:
    def isValid(self, s: str) -> bool:
        new_list=[]
        for i in s:
            if i in ['[','{','(']:
                new_list.append(i)
            elif len(new_list)==0:
                return False
            elif (i ==']' and new_list[-1]=='[') or (i =='}' and new_list[-1]=='{') or(i ==')' and new_list[-1]=='('):
                new_list.pop()
            else:
                return False
            
        if len(new_list)!=0:
            return False
        return True
                
        