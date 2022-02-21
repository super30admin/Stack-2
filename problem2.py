# Time Complexity : O(m) m is the number of logs
# Space Complexity:o(n)
#  Did this code successfully run on Leetcode : Yes

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        stack = []
        result = [-1] * (len(nums))

        for i in range(0,2*len(nums)):
            while stack and nums[stack[-1]] < nums[i% len(nums)]:
                result[stack[-1]] = nums[i%len(nums)]
                stack.pop()

            stack.append(i% len(nums))

        return result
