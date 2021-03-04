#Time Complexity :o(n)
#Space Complexity :o(n)
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :no

class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        if(s==None or len(s)==0):
            return True

        stack=[]
        
        hmap={')':'(','}':'{',']':'['}
    
        for i in range(len(s)):
            if(s[i] in hmap):
                if(not stack):
                    return False
                brac=stack.pop()
                if(hmap[s[i]]!=brac):
                    return False
            else:
                stack.append(s[i])
        
        if(stack):
            return False
        return True
        
        
        
                
            