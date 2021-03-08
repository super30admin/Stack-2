# Time Complexity : O(m) [where 'm' = len(logs)]
# Space Complexity : O(m)

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        
        result = [0] * n
        if not logs: return []
        stack = []
        prev = 0
               
        for log in logs:
            log_arr = log.split(':')
            curr = int(log_arr[2])
            
            if log_arr[1] == 'start':
                if stack:
                    result[stack[-1]] += curr - prev
                    prev = curr
                
                stack.append(int(log_arr[0]))
            else:
                job = stack.pop()
                result[job] += curr + 1 - prev
                prev = curr + 1
                
        return result