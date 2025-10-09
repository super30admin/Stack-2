class Solution:
    # Defining a function to calculate exclusive time of each function
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        stack = []  # Using a stack to keep track of function calls
        result = [0] * n  # Initializing result array to store exclusive times
        prev = 0  # Keeping track of previous timestamp

        # Iterating through each log entry
        for log in logs:
            splitArr = log.split(":")  # Splitting log into components
            processId = int(splitArr[0])  # Extracting process id
            processType = splitArr[1]  # Extracting process type (start/end)
            curr = int(splitArr[2])  # Extracting current timestamp

            if processType == "start":
                # If stack is not empty, updating exclusive time for previous function
                if stack:
                    result[stack[-1]] += curr - prev
                # Pushing current process id onto stack
                stack.append(processId)
            else:
                # Adjusting current timestamp for end log
                curr = curr + 1
                # Updating exclusive time for function ending now
                result[stack.pop()] += curr - prev

            # Updating previous timestamp
            prev = curr

        # Returning the result array containing exclusive times
        return result

# Time Complexity (TC): O(L), where L is the number of logs.
# Space Complexity (SC): O(n + L), where n is the number of functions and L is the stack size in worst case.
