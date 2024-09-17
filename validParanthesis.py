'''
Time Complexity: O(n)
Space Complexity:O(n)
Did this code successfully run on Leetcode : Yes
Explanation: Create a stack and if we see the open bracket we push the bracket into the stack and if we see a closing
bracket we check if top of stop is the corresponding closing bracket, if it is pop if not its invalid and return False.
If length of stack is 0 then we popped all valid brackets and return true
'''

class Solution:
    # Better looking  way to do it
    def isValid(self, s: str) -> bool:
        stack = []
        brackets = {
            '(': ')', '{': '}', '[': ']'
        }

        for i in range(0, len(s)):
            current = s[i]
            if current in brackets:
                stack.append(current)

            elif len(stack) != 0 and current == brackets[stack[-1]]:
                stack.pop()
            else:
                return False
        return len(stack) == 0