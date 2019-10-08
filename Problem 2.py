# Time Complexity : O(s)
# Space Complexity :O(s)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def isValid(self, s: str) -> bool:
        dct = {")": "(", "]": "[", "}": "{"}
        stack = []
        for item in s:
            if item not in dct:
                stack.append(item)
            if item in dct:
                if not stack:
                    return False
                elif dct[item] != stack.pop():
                    return False
        if len(stack) != 0:
            return False
        return True
