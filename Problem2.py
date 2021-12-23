#636 Exclusive Time of functions
# Time - O(n)
# Space - O(n)
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        
        stack = []
        result = [0] * n
        
        prev = 0
        curr = 0
        
        for log in logs:
            
            arr = log.split(":")
            curr = int(arr[2])
            if arr[1] == "start":
                
                if len(stack) != 0:
                    
                    result[stack[-1]] = result[stack[-1]] + curr - prev
                    
                stack.append(int(arr[0]))
                prev = curr
            else:
                
                result[stack.pop()] +=  curr + 1 - prev
                prev = curr + 1
        
        return result