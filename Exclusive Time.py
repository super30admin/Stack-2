# TC O(n)
# SC O(n) to maintain the stack
# Code ran on LeetCode
# Keep updating the stack based on the current instruction and update the exclusive time based on end time and of a function.

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        stack = []; prev_time = 0
        res = [0]*n
        for log in logs:
            idx, ins, time = log.split(':')
            idx = int(idx); time = int(time)
            if ins == 'start':
                if stack:
                    res[stack[-1][0]] += time - prev_time
                stack.append((idx, time))
                prev_time = time
            else:
                last, last_time = stack.pop()
                res[last] += time - prev_time + 1
                prev_time = time + 1
        return res
