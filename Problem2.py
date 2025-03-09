# This is a stack approach where we check if it's in dictionary if it's closed bracket and pop if it's equal or return False
# TC: O(N)
# SC: O(1)

class Solution:
    def isValid(self, s: str) -> bool:
        d = []
        dic = {']': '[', '}': '{', ')': '('}
        for i in s:
            if i in dic:
                if len(d) == 0:
                    return False
                if dic[i] == d[-1] :
                    d.pop()
                else: 
                    return False
            else:
                d += i
        return len(d) == 0

