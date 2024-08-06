#tc = O(n)
#sc = O(n)
from typing import List
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        res=[0]*n
        stack = []
        prev = 0
        for str in logs:
            splitList = str.split(":")
            curr = int(splitList[2])
            task = int(splitList[0])
            if splitList[1] == "start":
                if stack:
                    res[stack[-1]]+=curr-prev
                prev = curr
                stack.append(task)
            else:
                res[stack.pop()]+=curr+1-prev
                prev = curr+1
        return res