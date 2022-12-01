# TC: O(N)
# SC: O(N)

class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        mapping = {')': '(', '}': '{', ']': '['}

        # for each element in string
        for char in s:
            # if closing bracket in mapping
            if char in mapping:
                # pop the top element
                topelement = stack.pop() if stack else "#"

                if mapping[char] != topelement:
                    return False
            else:
                stack.append(char)
        return not stack