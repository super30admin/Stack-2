"""
add to stack if the fuction is starting =, if a function already exists in the stack updtate the runtime so far in res.
When the function call ends calculate the runtime so far with respect to recent start
TC: O(n)
SP:O(n)
"""

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        stack = []
        res = [0] * n
        for l in logs:
            i, act, time = l.split(":")
            if act == "start":
                if not stack:
                    stack.append([int(i), int(time)])
                else:
                    top = stack[-1]
                    res[top[0]] += int(time) - top[1]
                    stack.append([int(i), int(time)])
            else:
                f_id, s = stack.pop()
                res[f_id] += int(time) - s + 1
                if stack:
                    stack[-1][1] = int(time) + 1

        return res
