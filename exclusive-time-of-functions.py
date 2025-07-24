# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        # Initialize result array to store exclusive time for each function
        result = [0] * n
        stack = []  # Stack to track function calls
        prev_time = 0  # Previous timestamp
        
        for log in logs:
            # Parse the log entry
            function_id, action, timestamp = log.split(':')
            function_id, timestamp = int(function_id), int(timestamp)
            
            if action == "start":
                # If there's a function running, add its execution time
                if stack:
                    result[stack[-1]] += timestamp - prev_time
                # Push current function onto stack
                stack.append(function_id)
                prev_time = timestamp
            else:  # action == "end"
                # Pop the function that just ended
                stack.pop()
                # Add execution time (end time is inclusive, so +1)
                result[function_id] += timestamp - prev_time + 1
                prev_time = timestamp + 1
        
        return result
        