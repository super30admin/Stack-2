#As taught in class, using stack to inser the opening brackts and pop when the same closing bracket is encountered. If stack is empty than means string is valid
#Time complexity and space complexity: O(n)

class Solution:
    def isValid(self, s: str) -> bool:
        st = list()
        if len(s) == 0 or s is None:
            return False
        if len(s) ==1:
            return False
        for i in range(len(s)):
            if (s[i]=="(" or s[i] =="[" or s[i]=="{"):
                st.append(s[i])
            elif(s[i]==")" or s[i]=="}" or s[i]== "]"):
                if len(st)!=0:
                    elem = st[-1]
                    if (elem is not None and ((elem=="(" and s[i]==")") or (elem=="{" and s[i]=="}") or (elem=="[" and s[i]=="]"))):
                        st.pop()
                    else:
                        return False
        if (len(st)==0):
            return True
        else:
            return False