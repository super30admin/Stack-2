#Time Complexity = O(n)
#Space Complexity = O(n)

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        result = [0] * n  
        stack = []  # Stack to track active function calls
        prevTime = 0  # Track the last processed timestamp

        for log in logs:
            fid, typ, timestamp = log.split(":")
            fid, timestamp = int(fid), int(timestamp)

            if typ == "start":
            # If there's an active function, update its exclusive time
                if stack:
                    result[stack[-1]] += timestamp - prev_time
            # Push current function onto stack
                stack.append(fid)
                prev_time = timestamp
            else:  
            # Pop the function from the stack and update its time
                result[stack.pop()] += timestamp - prev_time + 1
                prev_time = timestamp + 1  # Move past the end timestamp

        return result