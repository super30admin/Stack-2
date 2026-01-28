# Time Complexity :O(n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no


# Your code here along with comments explaining your approach
# We use a stack to store opening brackets as we traverse the string.
# When a closing bracket is encountered, we check whether it matches the top of the stack.
# If all brackets are matched correctly and the stack is empty at the end, the string is valid.

class Solution:
    def isValid(self, s: str) -> bool:
        stack = deque()
        hashmap = {")":"(","}":"{","]":"["}
        for i in s:
            if i == ")" or i == "}" or i == "]":
                if not stack:
                    return False
                top_ele = stack.pop()
                if hashmap[i] != top_ele:
                    return False
            else:
                stack.append(i)
        if stack:
            return False
        return True