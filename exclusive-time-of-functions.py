'''
TC: O(L)
SC: O(L)
'''
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        if not n:
            return []
        
        time = [0 for _ in range(n)]
        prev = 0
        stack = list()
        
        for log in logs:
            idm, typ, val = log.split(":")
            val = int(val)
            idm = int(idm)
            
            if typ == "start":
                if stack:
                    time[stack[-1]] += val - prev
                    prev = val
                stack.append(idm)
            else:
                time[stack[-1]] += val + 1 - prev
                prev = val + 1
                stack.pop()
        
        return time