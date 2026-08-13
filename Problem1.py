# Problem1: Exclusive Time of Functions (https://leetcode.com/problems/exclusive-time-of-functions/)
# Time Complexity: O(m) where m is the number of logs, since each log is processed once with constant work
# Space Complexity: O(m) in the worst case, since the stack can hold up to m nested function calls
# Approach: use a stack to track which function is currently running. Every time a start or end event happens, credit the elapsed time since the last checkpoint to whoever was on top of the stack, then move the checkpoint forward

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        stack = []             # holds ids of active functions, top of stack is the one currently running
        result = [0] * n       # will store exclusive time for each function id
        previous = 0           # timestamp of the last checkpoint we accounted for

        for log in logs:                          # go through each log in chronological order
            split_array = log.split(":")            # break "0:start:3" into ["0","start","3"]
            process_id = int(split_array[0])         # convert id to int so it can index result
            process_type = split_array[1]            # either "start" or "end"
            current = int(split_array[2])            # convert timestamp to int

            if process_type == "start":
                if stack:
                    # a function was already running, it just got interrupted
                    # give it credit for the time it ran since previous
                    result[stack[-1]] += current - previous
                stack.append(process_id)             # the new function is now running, push it on top

            else:
                # an end log means the function was still running during that timestamp
                # shift current forward by one so that timestamp gets fully counted
                current = current + 1
                # the function on top just finished, pop it off and give it credit
                result[stack.pop()] += current - previous

            previous = current                       # move the checkpoint forward for the next log

        return result

