class Solution: 
    def isValid(self, s: str) -> bool:
        map = {
              ")" : "(",
            "}" :  "{",
            "]" : "["
        }
        stack = []

        for val in s:
            if val in "({[":
                stack.append(val)
            elif val in map:
                if not stack or stack[-1] != map[val]:
                    return False 
                stack.pop()
            else:
                return False
        return not stack


if __name__ == "__main__":
    s = Solution()
    print(s.isValid("()"))
    print(s.isValid("()[]{}"))
    print(s.isValid("(]"))
    print(s.isValid("([])"))

# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : 
# - Initially, I used '=' instead of '==' inside the if condition.
# - I also returned True inside the loop by mistake (should be outside).

# Your code here along with comments explaining your approach :

# Approach:
# 1. Use a stack to store opening brackets.
# 2. When a closing bracket appears, check if it matches the latest opening one.
# 3. If mismatched or stack empty, return False.
# 4. After traversal, stack should be empty if all brackets matched.