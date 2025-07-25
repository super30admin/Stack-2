# TimeCompelxity:O(n)
# SpaceComplexity:O(n)
# Approach:If we have only one type of brackets we can have open and close count but that fails if we have more than one type so we maintainstack to get last occurence




class Solution:
    def isValid(self, s: str) -> bool:
        st=[]
        for i in s:
            if i =="(":
                st.append(")")
            elif i=="{":
                st.append("}")
            elif i=="[":
                st.append("]")
            else:
                if len(st)==0 or i!=st[-1]:
                    
                    return False
                st.pop()
        if len(st):return False
        return True
