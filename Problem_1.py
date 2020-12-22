"""
Time Complexity : O(length of logs array)
Space Complexity : O(n)- stack space 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
we iterate over the logs and split the 3 details. Initially we keep a previous value as 0. While iterating,
if we get a start process, we append it to the stack and change the value of prev. Also, we modify the running time
of previous process. In case we encounter an end process, we pop out the latest process, modify its
running time and update prev.
"""


class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        if not logs:
            return logs
        stack = []
        prev = 0
        result = [0 for i in range(n)]
        for i in range(len(logs)):
            idd, process, curr = logs[i].split(':')
            idd = int(idd)
            curr = int(curr)
            if process == 'start':
                if stack:
                    result[stack[-1]] += curr-prev
                    prev = curr
                stack.append(idd)
            else:
                result[stack.pop()] += curr-prev+1
                prev = curr+1
        return result
