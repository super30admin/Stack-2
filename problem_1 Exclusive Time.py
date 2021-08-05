# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach


class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        stack = []
        prev = 0
        result = [0 for i in range(n)]
        for i in logs:
            nums = i.split(":")
            curr = int(nums[2])
            if nums[1] == 'start':
                if stack:
                    result[stack[-1]] += curr - prev
                stack.append(int(nums[0]))
                prev = curr
            else:
                result[stack.pop()] += curr - prev + 1
                prev = curr + 1
        return result

