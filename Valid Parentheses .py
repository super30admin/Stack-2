
# STACK approach
# time : O(N)
# space : O(N)
# runs on leetcode: yes

class Solution:
    def isValid(self, s):
        # EDGE CASE
        if s == '' or len(s) == 0:
            return True
        if len(s) % 2 != 0:
            return False
        
        st = []
        opens = '([{'
        closers =')]}'

        for symbol in s:
            if symbol in opens:
                ind = opens.index(symbol)
                st.append(closers[ind])
            else:
                if st == []:
                    return False
                top = st.pop()
                if top != symbol:
                    return False
                
        if st != []:
            return False
        return True
    
    def isValid(self, s):
        # EDGE CASE
        if s == '' or len(s) == 0:
            return True
        if len(s) % 2 != 0:
            return False

        st = []
        for c in s:
            if c == '[':
                st.append(']')
            elif c == '(':
                st.append(')')
            elif c == '{':
                st.append('}')
            else:
                if len(st) == 0 or st.pop() != c:
                    return False
        if len(st) != 0:
            return False
        else:
            return True

        
obj = Solution()
print(obj.isValid(s='({'))
print(obj.isValid(s='({})'))
print(obj.isValid(s='({]}'))
print(obj.isValid(s='({[]})'))

            
