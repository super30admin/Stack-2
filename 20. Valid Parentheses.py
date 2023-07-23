#Time Complexity:O(n)
#Space Complexity:O(n)

class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        stack=[]
        for ele in s:
            if ele =='(':
                stack.append(ele)
            if ele =='[':
                stack.append(ele)
            if ele =='{':
                stack.append(ele)
            if ele=='}':
                if len(stack)==0:
                    return False
                x=stack.pop()
                if x!='{':
                    return False
            if ele==']':
                if len(stack)==0:
                    return False
                x=stack.pop()
                if x!='[':
                    return False
            if ele==')':
                if len(stack)==0:
                    return False
                x=stack.pop()
                if x!='(':
                    return False
        if len(stack)!=0:
            return False
        return True
            