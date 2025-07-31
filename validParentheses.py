class Solution:
    def isValid(self, s: str) -> bool:
        st=[]
        for i in s:
            if i in ['[','{','(']:
                st.append(i)
            else:
                if not st:
                    return False
                else:
                    c=st.pop()
                    print(c)
                    if not ((c=='[' and i==']')or(c=='(' and i==')')or(c=='{' and i=='}')):
                        return False
        return len(st)==0