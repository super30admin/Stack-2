# Time complexity - O(n)
# Space complexity -O(n)
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        stack = []
        prev = cur = 0
        res = [0]*n

        for log in logs:
            id,log_type,time = log.split(":")
            cur = int(time)
            
            if log_type == "start":
                if stack:
                    res[stack[-1]] += cur - prev 
                stack.append(int(id))
                prev = cur
            else:
                res[stack[-1]] += cur + 1 - prev
                stack.pop()
                prev = cur + 1
        return res
