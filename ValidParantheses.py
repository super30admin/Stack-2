# Time Complexity : O(n), where n is the length of the string
# Space Complexity : O(n)
def is_valid(s):
    if not s:
        return False

    stack = []
    matching_bracket = {')': '(', '}': '{', ']': '['}

    for char in s:
        if char in matching_bracket.values():
            stack.append(char)
        else:
            if not stack or stack.pop() != matching_bracket[char]:
                return False

    return not stack

# Examples:
print(is_valid("()"))         # True
print(is_valid("()[]{}"))     # True
print(is_valid("(]"))         # False
print(is_valid("([)]"))       # False
print(is_valid("{[]}"))       # True