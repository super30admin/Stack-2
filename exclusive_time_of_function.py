"""
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
Algorithm Explanation
Given below
"""
from collections import defaultdict
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        """
        Idea 
        Since we know that the given input is in order of tasks 
        being started and ended, along with interleaving, 
        we can use stack to and keep track of the previous execution time 
        and use it to compute the interval time
        """
        stk = []
        result = [0] * n
        prev_time = 0
        for i in range(len(logs)):
            log = logs[i].split(":")
            fid = int(log[0])
            proc_key = log[1]
            curr = int(log[2])
            if proc_key == "start":
                if stk:
                    #if there is prcess in the stack, update the result with the running execution time
                    result[stk[-1]] += curr - prev_time
                
                #update the stack with latest process id
                stk.append(fid)
                #update the prev time
                prev_time = curr
            elif proc_key == "end":
                #can pop directly the last process and update result to curr - prev + 1
                result[stk.pop()] += curr - prev_time + 1
                
                #update prev to next start time
                prev_time = curr + 1
        
        return result