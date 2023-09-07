class Solution:
    # Time Complexity: O(n)
    # Space Complexity: O(n)
    def isValid(self, s: str) -> bool:
        stack = []
        for i in s:
            if i == "(" or i == "[" or i == "{":
                stack.append(i)
            elif (len(stack)) > 0:
                el = stack.pop()
                if el == "(" and i != ")":
                    return False
                if el == "[" and i != "]":
                    return False
                if el == "{" and i != "}":
                    return False
            else:
                return False
        return len(stack) == 0
