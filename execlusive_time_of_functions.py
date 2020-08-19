# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''
1. Maintain a stack containing active function call. Every time a new func call occurs update the prev log's execution time by subtracting prev end time and curr time
2. When an end time of a func call is encountered, pop the lement from stack and update the prev logs execution time
by subtracting prev end time and curr time + 1

'''

from collections import deque
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        
        if len(logs) < 2:
            return
        
        log_map = [0]*n
        
        stack = deque()
        prev_end = 0
        for i in range(len(logs)):
            
            log_id, SE, time = tuple(logs[i].split(":"))
            
            if SE == "start":
                if stack:
                    peek_id = stack[-1]
                    log_map[peek_id] += int(time) - prev_end
                    
                stack.append(int(log_id))
                prev_end = int(time)
            else:
                log_map[stack.pop()] += int(time) - prev_end + 1
                prev_end = int(time) + 1
                
            
        return log_map
                
                
            
        