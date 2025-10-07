from typing import List

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        res = [0] * n
        stack = []
        prev = 0

        for log in logs:
            fn_str, typ, ts_str = log.split(':')
            fid = int(fn_str)
            t = int(ts_str)

            if typ == "start":
                if stack:
                    res[stack[-1]] += t - prev
                stack.append(fid)
                prev = t
            else:  # "end"
                finished = stack.pop()
                res[finished] += t - prev + 1
                prev = t + 1

        return res
# Time Complexity : O(L)  # L = number of logs, each processed once
# Space Complexity : O(n)  # stack + result array
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
# - Initially confused how to handle overlapping times (when one function pauses while another runs).
# - Fixed by updating the top of stack’s function time before pushing a new one.

# Your code here along with comments explaining your approach :
# --------------------------------------------------------------
# Approach:
# We simulate the call stack using a list.
# Each log has three parts: function_id, "start"/"end", and timestamp.
# 
# When a function starts:
#   - If another function was already running (stack not empty),
#     we add the time spent since the previous timestamp to the top function.
#   - Then we push the new function onto the stack.
#
# When a function ends:
#   - We pop it from the stack and add its total duration
#     (current_time - previous_time + 1) since 'end' is inclusive.
#   - Update previous timestamp to current_time + 1.
#
# The final result array will store the exclusive time for each function.