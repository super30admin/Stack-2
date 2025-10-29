class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        # using stack whwre i get a closign bracket will pop it out and if it is not the pair of that closing bracket then return false in the end return the stack size is null or not
        # tc : O(n), sc :O(n) stack space
        if len(s) == 0:
            return True
        
        stack = []
        mapping = {")" :"(", "}":"{", "]":"[" }
        
        i = 0
        while (i< len(s)):
            if s[i] in mapping and len(stack) > 0:
                bracket = stack.pop()
                if mapping[s[i]] != bracket:
                    return False
            else:
                stack.append(s[i])
            i +=1
            
        return len(stack) == 0 # checking the size so that in case any opening brackets are left that means is invalid, in the end out stack should be empty to be valid
        