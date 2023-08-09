# Time Complexity: O(N), where N is the number of logs
# Space Complexity: O(N), where N is the number of logs

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        # Initialize a list to store the exclusive time intervals for each function
        result = [0] * n
        
        # Initialize a stack to keep track of function IDs
        stack = []
        
        # Initialize variables to keep track of current time and previous timestamp
        curr, prev = 0, 0
        
        # Iterate through each log entry
        for log in logs:
            # Split the log entry into components
            strArr = log.split(':')  # Format: ["ID", "start/end", "timestamp"]
            
            # Extract the function ID and timestamp
            currId = int(strArr[0])
            curr = int(strArr[2])
            
            # Check if the log entry represents the start of a function
            if strArr[1] == 'start':
                # Calculate the exclusive time for the previous function
                if stack:
                    result[stack[-1]] += curr - prev
                
                # Push the current function ID onto the stack
                stack.append(currId)
                
                # Update the previous timestamp
                prev = curr
            else:
                # Calculate the exclusive time for the current function
                result[stack.pop()] += curr + 1 - prev
                
                # Update the previous timestamp
                prev = curr + 1
        
        # Return the list of exclusive time intervals for each function
        return result
