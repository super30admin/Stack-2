class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        mapped = {'}':'{', ']':'[', ')':'('}
        for c in s:
            if c in mapped:
                if not stack or stack.pop() != mapped[c]:
                    return False
            else:
                stack.append(c)
        return not stack

%TC:O(n)
%SC:O(n)