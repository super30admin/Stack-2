class Solution:
    def isValid(self, s: str) -> bool:
      # Time Complexity: O(n)
      # Space Complexity: O(n)
        st=[]
        o = set(["(","{","["])
        for i in s:
            if(i in o):
                st.append(i)
            elif(i=="]"):
                if(len(st)>0 and st[-1]=="["):
                    st.pop()
                else:
                    return False
            elif(i=="}"):
                if(len(st)>0 and st[-1]=="{"):
                    st.pop()
                else:
                    return False
            elif(i==")"):
                if(len(st)>0 and st[-1]=="("):
                    st.pop()
                else:
                    return False
        if(len(st)>0):
            return False
        else:
            return True
