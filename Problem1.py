class Solution:
    """
    
            Name : Shahreen Shahjahan Psyche
            Language Used : Python
            Time : O(N)
            Space: O(N)
            Passed All The Test Cases in LC : Yes
            
            Approach : The goal is to use the property of stack to keeep thee track of the incoming and outgoing flow of a function. When a function's log comes,
                       saving it inside a current variablee and checking whether there is any eexisting proceess is inside stack. If yes, that means the process
                       was running. So, I peek the stack and save the time of that stack peek process in reesultant array. Then, push thee current process to thee
                       stack and curreent' processes time stamp becomes previous onee. If we eencoounter an end flag in the log, than we just go ahead, simply pop 
                       the stack top which givees me the current process's result index. I just increasee the value by one and prev becomes curr + 1
    
    
    """
    
    
    
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        
        if not logs:
            return []
        
        stack = []
        track = [0 for i in range(n)]
        prev = 0
        curr = 0
        
        for i in range(len(logs)):
            log = logs[i].split(":")
            curr = int(log[2])     
            if log[1] == "start":
                if stack:
                    track[stack[-1]] += curr - prev
                stack.append(int(log[0]))
                prev = curr    
            else:
                track[stack[-1]] += curr - prev + 1
                stack.pop()
                prev = curr + 1
                
            
        return track
                
            
            
            
        
