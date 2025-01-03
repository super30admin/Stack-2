# Approach:
# - Use a stack to keep track of active functions and their start times.
# - Parse the logs to handle each event (start or end).
# - Calculate the exclusive time for each function based on the difference between timestamps.
# - If a function ends, adjust the execution time for the parent function (if any) on the stack.

# Time Complexity: O(L), where L is the number of logs.
# Space Complexity: O(N), where N is the maximum depth of the function call stack.
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: None

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        # Initialize result array to store exclusive times for each function
        result = [0] * n
        # Stack to store active functions and their start times
        stack = []
        # Variable to track the previous timestamp
        prev_time = 0

        for log in logs:
            # Parse the log into function ID, action, and timestamp
            func_id, action, timestamp = log.split(":")
            func_id, timestamp = int(func_id), int(timestamp)

            if action == "start":
                # If a function is starting, calculate the elapsed time for the current function on the stack
                if stack:
                    result[stack[-1]] += timestamp - prev_time
                # Push the current function onto the stack
                stack.append(func_id)
                # Update the previous timestamp
                prev_time = timestamp
            else:
                # If a function is ending, calculate its total execution time
                result[stack.pop()] += timestamp - prev_time + 1
                # Update the previous timestamp to the time after the current function ends
                prev_time = timestamp + 1

        return result
