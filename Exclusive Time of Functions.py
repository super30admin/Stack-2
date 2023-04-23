# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        result = [0]*n
        prev = 0
        stack = []
        for log in logs:
            arr = log.split(":")
            task = int(arr[0])
            curr = int(arr[2])
            if arr[1] == 'start':
                if stack:
                    result[stack[-1]]+=(curr-prev)
                stack.append(task)
                prev = curr
            else:
                result[stack.pop()]+=(curr+1-prev)
                prev = curr+1
        return result