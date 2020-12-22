class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        
        stack = []
        
        result = [0]*n
        
        for log in logs:
            id, status, currTime = log.split(":")
            id, currTime = int(id), int(currTime)
            
            if status == "start":
                stack.append([id, currTime])
            else:
                oldTime = stack.pop()[1]
                timeTaken = currTime-oldTime+1
                result[id] += timeTaken
                
                if stack:
                    result[stack[-1][0]] -=timeTaken
        
        return result
    
Time: O(n)
Space: O(n)
