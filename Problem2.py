"""
I implemented the solution using a hashmap to map each closing bracket to its corresponding opening bracket. I used a stack to keep track of unmatched opening brackets. For each character in the string, if it's a closing bracket, I check if it matches the top of the stack. If it does, I pop the top element; otherwise, the string is invalid.
Time Complexity: O(n)
Space Complexity: O(n)
"""
class Solution:
    def isValid(self, s: str) -> bool:

        hashMap = {')' : '(', ']' : '[', '}' : '{'}
        stack = []
        for char in s:
            if char in hashMap:
                if stack and stack[-1] == hashMap[char]:
                    stack.pop()
                else:
                    return False
            else:
                stack.append(char)
        return len(stack) == 0 