Valid Parentheses:
------------------
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.

Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true

Example 2:

Input: "()[]{}"
Output: true

Example 3:

Input: "(]"
Output: false

Time = O(n) Space = O(n)

class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        if s == None or len(s) == 0:
            return True
        stack = []
        for c in s:
        #push the closing brackets
            if c == '(':
                stack.append(')')
            if c == '[':
                stack.append(']')
            if c == '{':
                stack.append('}')
         #check if the peek value and if its true return true else false
            if c == ')' or c == ']' or c == '}':
            #we check this condition for value '}' 
                if len(stack) == 0:
                    return False
                if c != stack.pop():
                    return False
        return len(stack) == 0
                
           
            
