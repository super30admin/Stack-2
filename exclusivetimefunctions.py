#Time Complexity: O(n)
#Space Complexity: O(n)
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        res = [0]*n
        lst = []
        stack = []
        curr = 0
        for log in logs:
            lst = log.split(':')
            curr = int(lst[2])
            if lst[1] == 'start':
                if stack:
                    res[stack[-1]] += curr - prev
                stack.append(int(lst[0]))
                prev = curr
                
            if lst[1] == 'end':  
                if stack:
                    res[stack[-1]] += (curr-prev) + 1
                    prev = curr +1
                    stack.pop()
                    
        return res
            