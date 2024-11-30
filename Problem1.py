# Problem 1: Valid Parentheses
class Solution:
    def isValid(self, s: str) -> bool:
        st = []
        for c in s:
            if c == "(":
                st.append(")")
            elif c == "[":
                st.append("]")
            elif c == "{":
                st.append("}")
            elif c == ")":
                if len(st) == 0 or st[-1] != ")":
                    return False
                st.pop()
            elif c == "]":
                if len(st) == 0 or st[-1] != "]":
                    return False
                st.pop()
            elif c == "}":
                if len(st) == 0 or st[-1] != "}":
                    return False
                st.pop()

        return len(st) == 0
        