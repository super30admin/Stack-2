"""
Aproach: Using stack

Here we will use a stack.

We will maintain a curr and prev pointer, which will always point end and start point for a particular log. We will use stack store the unfinished processes that will be finished later in the future. We will also maintain a result array of size n.


Algorithm:

1) Push the function id of the first function in the logs list on the stack.

2) Take the difference between the next function's start/stop(curr) time and the current function's start/stop(prev) time and add it to the current value at ith index index in result.

3) If the next function has a 'start' label, push this function's id onto the stack. Otherwise, increment the last function's exclusive time(along with the current time), and pop the function id from the top of the stack.

4) Repeat steps 2 and 3 till all the functions in the logslogs list have been considered.

5) Return the resultant exlcusive time(res).

TC: O(n)
SC: O(n)

n = no of logs
"""

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        if logs == None or len(logs) == 0:
            return []
        
        result = [0] * n
        stack = []
        prev = 0
        
        for log in logs:
            info = log.split(':')
            ID = int(info[0])
            fun = info[1]
            curr = int(info[2])
            
            # if start push into the stack
            if fun == "start":
                
                # before pushing another ID into stack first complete the calculation related to                        current top value on the stack
                if stack:
                    result[stack[-1]] += curr - prev
                    prev = curr
                stack.append(ID)
            
            # if end pop from stack
            else:
                result[stack.pop()] += curr - prev + 1
                prev = curr + 1
                
                
        return result
        
        
        