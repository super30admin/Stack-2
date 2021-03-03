
#Time Complexity: O(N)
#Space Complexity: O(N)
#Run on Leetcode: Yes
#Any Issues: No

class Solution:
    def isValid(self, s: str) -> bool:
        sl = list(s)
        t = []
        d = {'(': ')','[': ']','{': '}'}
        while sl:
            c = sl.pop(0)
            if not t:
                t.append(c)
            else:
                if c == d.get(t[-1], None):
                    t.pop(-1)
                else:
                    t.append(c)
        return len(t) == 0