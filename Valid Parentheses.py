#Time Complexity : O(N) where N is number of elemeents
#Space Complexity :O(N) where N is number of elemtns stored
class Solution:
    def isValid(self, s: str) -> bool:
        st = []
        for i in  s:
            if i == "{":
                st.append("}")
            elif i == "(":
                st.append(")")
            elif i == "[":
                st.append("]")
            elif len(st) == 0 or st[-1] != i:
                return False
            elif st[-1] ==i:
                st.pop()
        return len(st) == 0