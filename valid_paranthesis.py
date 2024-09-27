// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
we start with each in the string and if it is a opening bracket we insert the other closing bracket into the stack else if it is a closing bracket then we pop the bracket from the stack.If the stack is empty in the end then we say that the it is a valid paranthesis.

# Time complexity --> o(n)
# space complexity --> o(n)
class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        if s==None or len(s)==0:
            return True
        stack=[]
        for i in range(len(s)):
            if s[i]=='[' or s[i]=='{' or s[i]=='(':
                if s[i]=='[':
                    stack.append(']')
                if s[i]=='{':
                    stack.append('}')
                if s[i]=='(':
                    stack.append(')')
            else:
                if len(stack)>0 and stack[-1]==s[i]:
                    stack.pop()
                else:
                    return False
        if len(stack)==0:
            return True
        return False
        