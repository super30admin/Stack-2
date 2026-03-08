''' Time Complexity : O(n) 
    Space Complexity : O(n) 
    Did this code successfully run on Leetcode : Yes
'''

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        stack = []
        prev = 0
        result = [0] * n
        for log in logs:
            l = log.split(":")
            id,action,curr = int(l[0]),l[1],int(l[2])
            if action == "start":
                if stack:
                    result[stack[-1]] += curr - prev
                stack.append(id)
            else:
                curr += 1
                result[stack.pop()] += curr -prev
            
            prev = curr
        return result

        