#Time Complexity : O(n)
#Space Complexity : O(n)
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :No

class Solution:
    def isValid(self, s: str) -> bool:
        if s is None:
            return False
        
        stack = []

        for ch in s:
            if ch == "(":
                stack.append(")")
            elif ch == "{":
                stack.append("}")
            elif ch == "[":
                stack.append("]")
            else:
                if not stack:
                    return False
                if stack.pop() != ch:
                    return False
        
        return not stack
