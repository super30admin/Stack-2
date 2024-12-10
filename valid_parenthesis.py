"""
approach1: inside the stack, store the opening type bracket.
If the closing type bracket comes, then check if it's a matching type. If no, then return False.
TC: O(n) and SC: O(n)

Note: If there is only one type of bracket such as () or {} or []
 use a count variable to store the number of opening brackets, if closing is encountered decrease it.
 check count in betwene as well. If is <0 then Faslse.
if at the end count = 0 then valid else False
another approach:
But for different type of bracket use list of size number of the different type of bracket.
THis will fail for [({)}]. Since the list does not take order care.
If keep track last character, this will fail for: [({()]}
THus, counter-method works for the same type of brackets not different type.
"""


class Solution_with_space:
    def isValid(self, s: str) -> bool:

        stack = []
        for ch in s:
            if ch == "[" or ch == "(" or ch == "{":
                stack.append(ch)

            elif ch == "]":
                if stack and stack[-1] == "[":
                    stack.pop()
                else:
                    return False

            elif ch == ")":
                if stack and stack[-1] == "(":
                    stack.pop()
                else:
                    return False

            elif ch == "}":
                if stack and stack[-1] == "{":
                    stack.pop()
                else:
                    return False

        if stack:
            return False
        else:
            return True

