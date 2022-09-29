"""
Time Complexity :
Space Complexity :
Did this code successfully run on Leetcode :
Any problem you faced while coding this :


Your code here along with comments explaining your approach
Problem1 Exclusive Time of Functions (https://leetcode.com/problems/exclusive-time-of-functions/)
"""

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        """
        Using a stack to keep the logs, maintaing a prev pointer for the previous log. Cal the difference of the current log from the prev and recording it as the timestamp for curr log from the stack.
        TC:
        SC:
        """
        # create the result array of size n
        res = [0 for i in range(n)]
        
        # Create stack to store the logs in LIFO order
        stack = []
        prev = 0
        
        for log in logs:
            log = log.split(":")
            log_id = int(log[0])
            log_status = log[1]
            curr = int(log[2])
            # check if the task is START then we will take the diff of prev and curr as our total timespan
            if log_status == "start":
                if stack:
                    res[stack[-1]] += curr - prev
                    
                prev = curr
                stack.append(log_id)
            # if the task is ENd then we will add one to the timespan as the curr time has completed one unit of time    
            elif log_status == "end":
                res[stack.pop()] += curr + 1 - prev
                prev = curr + 1
                
                
        return res
                
            
            
            
        
        
        