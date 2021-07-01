"""636. Exclusive Time of Functions
Time Complexity: O(N)
Space Complexity: O(N)"""

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        result = [0]*n
        if logs is None and len(logs)==0:
            return 
        
        prev =0
        stack = []
        for log in logs:
            strs = log.split(":")
            if strs[1] == "start":
                if stack:
                    result[stack[-1]] +=int(strs[2])-prev
                stack.append(int(strs[0]))
                prev = int(strs[2])
            else:
                result[stack.pop()] +=int(strs[2])-prev+1
                prev = int(strs[2])+1
        return result
            