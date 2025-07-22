"""
Use a stack to track open brackets
On encountering a closing bracket, check if it matches the top of the stack
If the stack is empty at the end, the parentheses are valid
"""
"""
Time Complexity - O(n)	One pass through the string
Space Complexity - O(n)	Stack in worst case (all open brackets)
"""


class validParanthesis:
    def isValid(self, s: str) -> bool:
        stack = []
        mapping = {')': '(', ']': '[', '}': '{'}

        for char in s:
            if char in mapping:
                top = stack.pop() if stack else '#'
                if mapping[char] != top:
                    return False
            else:
                stack.append(char)
        return not stack

if __name__ == "__main__":
    obj = validParanthesis()
    print(obj.isValid("()"))       
    print(obj.isValid("()[]{}"))  
    print(obj.isValid("(]"))    
    print(obj.isValid("([)]"))  
    print(obj.isValid("{[]}")) 
