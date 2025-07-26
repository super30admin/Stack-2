# Time complexity: O(n)
# Space complexity: O(n)

def isValid(s):
    stack = []
    bracket_map = {")": "(", "}": "{", "]": "["}
    for char in s:
        if char in bracket_map.values():
            stack.append(char)
        elif char in bracket_map.keys():
            if stack == [] or bracket_map[char] != stack.pop():
                return False
    return stack == []
