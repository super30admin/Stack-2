"""
Valid Parentheses (https://leetcode.com/problems/valid-parentheses/)

"""

class Solution:
    def isValid(self, s: str) -> bool:
        """
        Tc: O(n)
        SC: O(N)
        """
        stack=[]
        dictionary={")":"(", "}":"{", "]":"["}
        for paranthesis in s:
            ###we have a opening bracket
            if paranthesis in dictionary.values():
                stack.append(paranthesis)
            ##we have a closing bracket
            elif stack and dictionary[paranthesis]==stack[-1]:
                stack.pop()
            else:
                return False
        return stack==[]
