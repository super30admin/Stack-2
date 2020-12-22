# Time Complexity: O(l) - l is number of log lines
# Space Complexity: O(n) - n is number of functions

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        stack = []
        result = [0 for _ in range(n)]
        for i in range(len(logs)):
            # If a task is beginning execution, push task id and time on stack 
            if 'start' in logs[i]:
                id_, time = int(logs[i].split(':start:')[0]), int(logs[i].split(':start:')[1])
                stack.append((id_, time))
            else:
                # If a task ends execution, pop from stack
                id_, time = int(logs[i].split(':end:')[0]), int(logs[i].split(':end:')[1])
                
                # Duration of the task that just ended
                duration = time - stack.pop()[1] + 1
                
                # Add duration to result
                result[int(id_)] += duration
                
                # Reduce 'duration' from the task on top of the stack (previous task)
                # This task was paused while the current task was executing.
                if stack:
                    result[stack[-1][0]] -= duration    
                    
        return result