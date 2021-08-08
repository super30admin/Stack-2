# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# use stack to keep track of order and match
class Solution:
    def isValid(self, s: str) -> bool:
        
        st = []
        
        for i in range(0,len(s)):
            if s[i] == "[":
                st.append("]")
            elif s[i] == "{":
                st.append("}")
            elif s[i] == "(":
                st.append(")")
            else:
                if len(st)==0 or s[i] != st.pop():
                    return False
        if len(st) != 0:
            return False
        return True
        