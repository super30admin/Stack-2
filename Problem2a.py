class Solution(object):
    def isValid(self, s):
        """
        Check if the given string contains valid parentheses.
        Time complexity: O(n)
        Space complexity: O(n)

        :type s: str
        :rtype: bool
        """
        if s is None or len(s) == 0:
            # Handle the case when the input string is None or empty.
            return False

        # Initialize an empty stack to keep track of opening parentheses.
        st = []

        for i in range(len(s)):  # Loop through each character in the string.
            c = s[i]  # Get the current character.

            if c == '(':  # If the current character is an opening parenthesis '('
                # Push the corresponding closing parenthesis ')' to the stack.
                st.append(')')
            elif c == '[':  # If the current character is an opening bracket '['
                # Push the corresponding closing bracket ']' to the stack.
                st.append(']')
            elif c == '{':  # If the current character is an opening brace '{'
                # Push the corresponding closing brace '}' to the stack.
                st.append('}')
            else:  # If the current character is a closing symbol
                # If the stack is empty or the current character does not match the top of the stack.
                if not st or s[i] != st[-1]:
                    # The parentheses are not balanced, return False.
                    return False
                # If the current character matches the top of the stack, pop the top element.
                st.pop()

        # If the stack is empty, all parentheses are balanced, return True. Otherwise, return False.
        return not st
