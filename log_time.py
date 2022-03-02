# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach

from typing import Deque, List


class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:

        if len(logs) == 0:
            return [0] * n

        li = [0] * n

        prev = 0
        curr = 0
        st = Deque()
        step = []

        for i in logs:
            step = i.split(':')

            if step[1] == 'start':
                curr = int(step[2])

                if not len(st) == 0:
                    li[st[-1]] += curr - prev

                prev = curr
                st.append(int(step[0]))

            else:
                curr = int(step[2])
                li[int(step[0])] += (curr - prev + 1)
                prev = curr + 1
                st.pop()

        return li
