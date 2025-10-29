class Solution:
    def isValid(self, s: str) -> bool:
        st=[]

        for c in s:
            if c in "([{":
                st.append(c)
            elif c == ")" and (not st or st.pop()!="("):
                return False
            elif c=="]" and (not st or st.pop()!="["):
                return False
            elif c=="}" and (not st or st.pop()!='{'):
                return False
        return not st
        