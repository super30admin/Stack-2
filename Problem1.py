## Problem1 Exclusive Time of Functions (https://leetcode.com/problems/exclusive-time-of-functions/)
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        """
        Time Complexity: O(L)
        - Where L is the total number of log entries (len(logs)).
        - We iterate through the logs array once, and each stack operation (append/pop) 
          as well as string splitting runs in O(1) time.

        Space Complexity: O(N + L) 
        - The `res` array requires O(N) space to store execution times for `n` functions.
        - The `stack` stores function IDs and can hold up to O(L) elements in the worst case 
          of deeply nested function calls (up to L/2 calls).
        """
        l = len(logs)
        res = [0] * n
        stack = []  # Keeps track of currently active/nested function IDs (top of stack is running)
        prevtime = 0  # Tracks the start timestamp of the current execution interval

        for log in logs:
            # Parse the log string into component values
            fnid, status, time = log.split(":")
            fnid, time = int(fnid), int(time)

            if status == 'end':
                # Function finishing execution:
                # Add time spent since `prevtime` through `time` (inclusive, hence + 1)
                res[stack.pop()] += time - prevtime + 1
                # Update next interval's start time to the unit immediately after `time`
                prevtime = time + 1
            else:
                # Function starting execution:
                # If another function was running, attribute elapsed time to it before pausing
                if stack:
                    res[stack[-1]] += time - prevtime
                # Push the new function onto the stack as the active process
                stack.append(fnid)
                # Update next interval's start time to `time`
                prevtime = time

        return res