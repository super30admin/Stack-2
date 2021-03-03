
#Time Complexity: O(N)
#Space Complexity: O(N)
#Run on Leetcode: Yes
#Any Issues: No

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        res = [0] * n

        stack = []
        for line in logs:
            fid, act, t = line.split(':')
            if act == 'start':
                pIdx = -1 if not stack else len(stack) - 1
                stack.append([int(fid), int(t), pIdx, 0])
            else:
                _, start, pIdx, incTime = stack.pop()
                execTime = int(t) - start + 1 - incTime
                res[int(fid)] += execTime
                if stack:
                    stack[pIdx][3] += int(t) - start + 1

        return res