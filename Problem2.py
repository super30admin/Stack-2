# Time Complexity : O(n) 
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

# Method 1 using a stack and all if else conditions for each type of bracket.
# class Solution:
#     def isValid(self, s):
#         if len(s) == 0:
#             return True 
#         stack = []
#         for i in range(len(s)):
#             if s[i] =='(':
#                 stack.append(')')
#             elif s[i] == '[':
#                 stack.append(']')
#             elif s[i] == '{':
#                 stack.append('}')
#             else:
#                 if stack:
#                     top = stack.pop()
#                     if s[i] != top:
#                         return False 
#                 else:
#                     return False
        
#         if len(stack) != 0:
#             return False 
#         return True 

# Method 2) Using a dictionary to store all the type of bracket. 
# We will store all open brackets in the stack and store all the closing brackets as keys in the map, with value 
# of its corresponding opening bracket.
# Faster solution. 
class Solution:
    def isValid(self, s):
        if len(s) == 0:
            return True 
        d = {
            '}': '{',
            ']': '[',
            ')': '('
        }
        stack = []
        for i in range(len(s)):
            if s[i] not in d: # opening bracket 
                stack.append(s[i])
            else:
                item = d[s[i]] 
                if stack:
                    top = stack.pop()
                    if item != top:
                        return False 
                else:
                    return False 
        
        if stack:
            return False 
        return True 

if __name__ == "__main__":
    s = Solution()
    
    # Test case 1:
    print(s.isValid("()[]{}"))
    
    # Test case 2:
    print(s.isValid("([)]"))
    
    # Test case 3:
    print(s.isValid("]"))