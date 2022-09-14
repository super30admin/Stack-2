#time Complexity: O(N)
#spaceComplexity : O(N)

def isValid(self, s: str) -> bool:
    stack = []
    for i in s:
        if i == '(':
            stack.append('(')
        elif i == "{":
            stack.append("{")
        elif i == "[":
            stack.append("[")
        elif i == "]" and len(stack) > 0 and stack[-1] == "[":
            stack.pop()
        elif i == "}" and len(stack) > 0 and stack[-1] == "{":
            stack.pop()
        elif i == ")" and len(stack) > 0 and stack[-1] == "(":
            stack.pop()
        else:
            return False
    return True if len(stack) == 0 else False