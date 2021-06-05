class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        if not logs:
            return []
        
        result = [0]* n
        
        stack = []
        cur, prev = 0, 0
        for i in range(len(logs)):
            idx,call,time =   logs[i].split(':')
            curr = int(time)
            if call == 'start':
                if stack:
                    result[stack[-1]] +=  curr - prev
                    prev = curr
                stack.append(int(idx))
            else:
                result[stack.pop()] += curr - prev +1
                prev = curr +1
            
        return result     
                
