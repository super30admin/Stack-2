# Time Complexity : O(N) n=length of logs
# Space Complexity : O(N) n=length of logs
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        res = [0 for i in range(n)]
        if not logs:
            return res
        
        stack = []
        prev = 0
        for log in logs:
            strs = log.split(':')
            curr = int(strs[2])
            if strs[1] == "start":
                if stack:
                    res[stack[-1]] += curr - prev
                    prev = curr
                stack.append(int(strs[0]))
            else:
                res[stack.pop()] += curr + 1 - prev
                prev = curr + 1
        return res