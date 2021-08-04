class Solution:
    def isValid(self, s: str) -> bool:
        """using only stack
        Time complexity-O(n)
        Space complexity-O(n)"""
        arr=[]
        if len(s)%2!=0:
            return False
        for i in range(len(s)):
            if s[i]=="{":
                arr.append("}")
            elif s[i]=="(":
                arr.append(")")
            elif s[i]=="[":
                arr.append("]")
            elif not arr or arr[-1]!=s[i]:
                return False
            elif arr[-1]==s[i]:
                arr.pop()
        return not arr
        
        """Using hashmap and stack
         Time complexity-O(n)
         Space complexity-O(n)"""       
        # hashmap={"{":"}","(":")","[":"]"}
        # arr=[]
        # if len(s)%2!=0:
        #     return False
        # for i in range(len(s)):
        #     if s[i] in hashmap:
        #         arr.append(s[i])
        #     else:
        #         if not arr or hashmap[arr[-1]]!=s[i]:
        #             return False
        #         arr.pop()
        # if len(arr):
        #     return False
        # return True
            
            
        