#TC and SC are both O(n)
class Solution:
    def isValid(self, s: str) -> bool:

        #If you see a open bracket push corresponding closing to stack, if it's a closing blindly pop stack and see if it matches, if it doesn't return False.
        #And also if there is nothing left to pop, but still closing brackets are there, then return False.
        st=[]
        for i in range(len(s)):
            c=s[i]
            if c=='(':
                st.append(')')
            elif c=='{':
                st.append('}')
            elif c=='[':
                st.append(']')
            elif len(st)==0 or c!=st.pop(): #len(st)==0 is needed in case of s=()]]]], here, stack will be empty as there are too many close brackets and we don't have anything in the stack to pop from.
                return False
        return True if len(st)==0 else False #in the end, stack should be empty

        