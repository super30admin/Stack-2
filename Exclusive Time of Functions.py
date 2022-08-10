# TC :O(n)
# SC :O(1)
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        result = [0] * n
        stack = []
        prev = 0
        for log in logs:
            splits = log.split(":")
            curr = int(splits[2])
            if "start" in log:               
                if stack:
                    result[stack[-1]] += curr-prev
                    prev = curr                
                stack.append(int(splits[0]))
            else:
                result[stack.pop()] += curr-prev+1
                prev = curr+1
        return result