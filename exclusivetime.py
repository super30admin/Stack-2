# // Time Complexity :O(n)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        
        stack = []
        prev_time = 0
        ans = [0 for i in range(n)]
        
        for i in range(0,len(logs)):
            fid, state, time = logs[i].split(':')
            fid, time = int(fid), int(time)
            
            if state == "start":
                if stack:
                    ans[stack[-1]] += time - prev_time
                
                stack.append(fid)
                prev_time = time
           
            else:
                ans[stack.pop()] += time - prev_time + 1
                prev_time = time + 1
            
        return ans