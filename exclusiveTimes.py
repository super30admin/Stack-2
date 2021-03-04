class Solution:
    
    """
    Description: Exclusive time of functions for a single thread processor from given logs
    
    Time Complexity: O(n)
    Space Complexity: O(n) {from O(n/2)}
    where, n is number of logs
    
    Approach: Use of stacks
    1. take a previous element as 0, and start an empty stack along with a result list of size n
    2. for each log split the log to start position, type of event ("start" or "end") and end position
    3. take current element to the end position of the log
       - for "start" event, we may peek the stack and update the value of result at this index by differencing value of current and previous elements
       - in addition, add 0th index of the log in stack until we find event "end" to resolve it
       - for "end", we may resolve the stack by popping it out and use that value as index of our resulting array to add time for the function (value)
       - once everything is resolved, return the result list
    """
    
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
    
        if logs == None or len(logs) == 0: return
        
        stack = []; result = [0]*n
        prev = 0
        
        for log in logs:
            log_items = log.split(":")
            curr = int(log_items[2])
            event = log_items[1]
            if event == "start":
                if len(stack) != 0:
                    result[stack[-1]] += curr - prev
                    prev = curr
                stack.append(int(log_items[0]))
            else:
                result[stack.pop()] += curr - prev + 1
                prev = curr + 1
                
        return result
