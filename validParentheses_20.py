# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

# // Your code here along with comments explaining your approach

class Solution:
    def isValid(self, s: str) -> bool:
        #stack to keep track of opening brackets
        stack = []
        
        #Hash map for keeping track of bracket mappings
        hmap = {')':'(', 
                '}':'{', 
                ']':'['}
        
        # If the character is an closing bracket, Pop the topmost element from the stack, if it is non empty
        # else, assign a dummy value of '#' to the top_element variable
        for char in s:
            if char in hmap:
                top = stack.pop() if stack else '#'
                # if mapping don't match, return False
                if hmap[char] != top:
                    return False
            else:
                #an opening bracket: push it onto the stack
                stack.append(char)
                
        return True if not stack else False
