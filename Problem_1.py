from typing import List
from collections import deque
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        result = [0] * n
        if logs == None or len(logs) == 0:
            return result
        st = deque()
        prev = 0
        for log in logs:
            strs = log.split(":")
            curr = int(strs[2])
            if strs[1] == 'start':
                if len(st) > 0:
                    result[st[-1]] += curr - prev
                    prev = curr
                st.append(int(strs[0]))
            else:
                result[st.pop()] += curr - prev + 1
                prev = curr + 1
        return result

# Time Complexity: O(n)
# Space Complexity: O(n)