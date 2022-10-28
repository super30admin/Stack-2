class Solution:
    def isValid(self, s: str) -> bool:
        if s is None:
            return False

        st = []
        # we put the corresponding closing value in the stack of parentheses
        # when we reach a closing parentheses we check if the stack is empty
        # if the top element of the stack is the corresponding opening parentheses
        for i in range(len(s)):
            c = s[i]

            if c == "(":
                st.append(")")
            elif c == "{":
                st.append("}")
            elif c == "[":
                st.append("]")
            elif len(st) == 0 or st.pop() != c:
                return False
        # Return True is stack is empty else False
        return len(st) == 0

# Stack
# Time Complexity: O(n)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
