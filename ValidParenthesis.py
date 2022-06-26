# TC - O(n)
# SC - O(n)
class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        stack = []
        bmap = {
            ")": "(",
            "}": "{",
            "]": "["
        }
        for char in s:
            if char == "(" or char == "[" or char == "{":
                stack.append(char)
            else:
                if stack:
                    stack_top = stack.pop()
                    if bmap[char] != stack_top:
                        return False
                else:
                    return False

        if stack:
            return False
        return True
