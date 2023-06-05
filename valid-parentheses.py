# TC: O(n) | SC: O(n)
import collections
class Solution:
    def isValid(self, s: str) -> bool:
        q=collections.deque()
        mappings={'(':')','[':']','{':'}'}
        for c in s:
            if c in ['(','[','{']:
                q.append(c)
            else:
                if not q or mappings[q[-1]]!=c:
                    return False
                else:
                    q.pop()
        return len(q)==0