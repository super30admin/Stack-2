# // Time Complexity : O(N)
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

class Solution:
    def exclusiveTime(self, n, logs):
        time = [0] * n  # result list
        stack = []  # to keep track of idx
        last_time = 0

        for log in logs:
            # split the strings
            idx, strs, t = log.split(':')
            idx, t = int(idx), int(t)

            # keep track of previous time and update time list accordingly
            if strs == "start":
                if stack:
                    time[stack[-1]] += t - last_time
                stack.append(idx)
                last_time = t

            # pop the idx from stack and update the time list, +1 since end time is inclusive
            else:
                time[stack.pop()] += t + 1 - last_time
                last_time = t + 1

        return time
