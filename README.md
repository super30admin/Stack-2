# Stack-2

## Problem1 Exclusive Time of Functions (https://leetcode.com/problems/exclusive-time-of-functions/)

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        stack = []
        res = [0] * n

        for i in logs:
            log = i.split(":")
            f_id, event, ts = int(log[0]), log[1], int(log[2])
            if event == "start":
                stack.append([int(ts),0])
            else:
                start, child = stack.pop()
                exc = ts - start + 1 - child
                res[f_id] += exc
                total_child_time = exc + child
                if stack:
                    stack[-1][1] += total_child_time
        return res




## Problem2 Valid Parentheses (https://leetcode.com/problems/valid-parentheses/)


class Solution:
    def isValid(self, s: str) -> bool:
        seq = list(s)
        bracket_map = {"(":")", "[":"]", "{":"}"}
        parastack = []
        
        if len(seq) <= 1 or seq[0] == ")" or seq[0] == "}" or seq[0] == "]":
            return False

        for i in seq:
            if i == "(" or i == "{" or i == "[":
                parastack.append(i)
            elif len(parastack) > 0 and i == bracket_map[parastack[-1]]:
                parastack.pop()
            else:
                return False
        
        return parastack == []
