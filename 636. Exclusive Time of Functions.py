'''
T = O(n)
S = O(n)

Approach:
Maintain a previos and a current pointer and a resultant array and
keep updating the resultant array based on the type of task and make the stack
insert update based on the stack
'''



class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        if not logs:
            return logs
        stack = []
        curr = 0
        prev = 0
        res = [0 for i in range(n)]
        for i in range(0,len(logs)):
            details = logs[i].split(":")
            curr = int(details[2])
            if details[1] == 'start':
                if stack:
                    res[stack[-1]] += curr - prev
                    prev = curr
                stack.append(int(details[0]))
            else:
                res[stack.pop()] += curr -prev + 1
                prev = curr + 1
        return res
            
        
        