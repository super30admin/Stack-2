#All TC passed on leetcode

class Solution:
    def isValid(self, s: str) -> bool:

        #Here we travers s and if its opening bracket then we push its corresponding closing bracket into stack. 
        #If we find a closing bracket then we check if matches the braket on top of stack. 
        #Time complexity - O(n)
        #Space complexity - O(n)
        dict = {'(':')', '[':']', '{':'}'}
        stack = []

        for i in range(len(s)):
            if s[i] in dict:
                stack.append(dict[s[i]])
            else:
                if not stack:
                    return False
                if stack and stack.pop()!=s[i]:
                    return False

        if len(stack)>0:
            return False
        
        return True