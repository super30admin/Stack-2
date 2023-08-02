class Solution(object):
    def isValid(self, s):
        """
        Recursion
        Check if the given string contains valid parentheses.

        Time complexity: O(n)
        Space complexity: O(n)

        :type s: str
        :rtype: bool
        """
        if not s:
            # If the input string is empty, it is considered balanced.
            return True

        def helper(s, i, stack):
            # Base case: If the end of the string is reached, check if the stack is empty.
            if i == len(s):
                # If the stack is empty, all parentheses are balanced, return True. Otherwise, return False.
                return not stack

            if s[i] in ['(', '[', '{']:
                # If the current character is an opening parenthesis, bracket, or brace, push it to the stack.
                stack.append(s[i])
            elif s[i] in [')', ']', '}']:
                if not stack:
                    # If the current character is a closing symbol and the stack is empty, the parentheses are not balanced, return False.
                    return False
                if s[i] == ')' and stack[-1] != '(':
                    # If the current character is ')', but the top of the stack is not '(', the parentheses are not balanced, return False.
                    return False
                if s[i] == ']' and stack[-1] != '[':
                    # If the current character is ']', but the top of the stack is not '[', the brackets are not balanced, return False.
                    return False
                if s[i] == '}' and stack[-1] != '{':
                    # If the current character is '}', but the top of the stack is not '{', the braces are not balanced, return False.
                    return False
                # If the current character and the top of the stack form a balanced pair, pop the top element from the stack.
                stack.pop()

            # Recursively check the next character in the string.
            return helper(s, i + 1, stack)

        # Start the recursive helper function from the beginning of the string with an empty stack.
        return helper(s, 0, [])
