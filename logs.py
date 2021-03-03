#Time Complexity -- O(len(logs))
#Space Complexity --O(len(logs))

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        
        result = [0]*n
        previous = 0
        stack = []
        
        for log in logs:
            currlog = log.split(':')
            currtime = int(currlog[2])
            if currlog[1] == 'start':
                if stack:
                    result[stack[-1]] += currtime - previous
                    previous = currtime
                stack.append(int(currlog[0]))
            else:
                result[stack.pop()] += currtime + 1 - previous
                previous = currtime + 1
                
        return result
            
                    
        
        
