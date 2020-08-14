--------------------------Exclusive Time of Processes------------------------------------------
# Time Complexity : O(N) as N is length of s 
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# First we will check start index and add the next start point to the prev end point and append to the stack, whe 
# I reach end pointer, then we will pop the index from the stack and add the remaining minutes as end-start+1.

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        if not logs or n == 0:
            return []
        
        res = [0]*n
        
        stack = []
        prev = 0
        for i in logs:
            temp = i.split(':')
            if temp[1] == 'start':
                if stack:
                    res[stack[-1]] +=  int(temp[2])-prev
                stack.append(int(temp[0]))
                prev = int(temp[2])
            else:
                res[stack.pop()] += int(temp[2])-prev+1
                prev = int(temp[2])+1
        return res
        
        
        