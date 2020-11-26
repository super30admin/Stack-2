"""
Leetcode: https://leetcode.com/problems/exclusive-time-of-functions/
Approach: Use stack to have process ids that are currently being processed,
    use curr and prev variable to keep track of start and end of each process and
    add it to the results array.

Time complexity : O(n). We iterate over the entire logs array just once.
    Here, n refers to the number of elements in the logs list.
Space complexity : O(n/2). The stack can grow upto a depth of atmost n/2.
    Here, n refers to the number of elements in the given logs list.
"""


class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:

        prev = 0
        curr = 0

        stack = []
        result = [0] * n

        # process the logs
        for log in logs:
            pid, func, curr = log.split(":")
            pid, curr = int(pid), int(curr)

            # Start
            if func == "start":
                if stack:
                    result[stack[-1]] += curr - prev
                stack.append(pid)
                prev = curr

            # End
            else:
                result[stack[-1]] += curr - prev + 1
                stack.pop()
                prev = curr + 1
        return result
