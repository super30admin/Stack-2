# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        hmap = {
            ')':'(',
            ']':'[',
            '}':'{'
        }
                
        stack = []
        
        for c in s:
            # If it is a closing parenthesis:
            # Pop element and save to top
            # If stack is empty, top = '#'
            if c in hmap:
                top = stack.pop() if stack else '#'
                # If the top element is not a corresponding open parenthesis
                # return False
                if hmap[c] != top:
                    return False
            else:
                stack.append(c)
        # If the stack is empty, return True
        return not stack