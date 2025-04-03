#  https://leetcode.com/problems/exclusive-time-of-functions/

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        prev = 0
        curr = 0
        stack = []
        res = [0] * (n)

        for log in logs:
            record = log.split(":")
            curr = int(record[2])
            if record[1] == "start":
                if stack:
                    res[stack[-1]] += curr - prev
                
                stack.append(int(record[0]))
                prev = curr
            else:
                res[stack[-1]] += curr-prev + 1
                stack.pop()
                prev = curr + 1

        return res

# TC :O(n)
# SC :O(n)