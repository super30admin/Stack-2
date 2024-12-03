class Solution(object):
    def isValid(self, s): #T.C -> O(N) , S.C->O(N)
        """
        :type s: str
        :rtype: bool
        """
        stack = []

        for i in range(len(s)):
            par = s[i]

            if par == '(':
                stack.append(')')
            elif par == '[':
                stack.append(']')
            elif par == '{':
                stack.append('}')
            elif len(stack) == 0 or par != stack.pop():
                return False
        return len(stack) == 0