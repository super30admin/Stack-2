class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        stack = []
        res = [0 for i in range(n)]
        #id, status, startTime, timeToSubtract
        for l in logs:
            id, status, time = l.split(":")
            if status == "end":
                pop = stack.pop()
                res[int(pop[0])] += int(time) - pop[2] + 1 - pop[3]
                if stack:
                    stack[-1][3] += (int(time) - pop[2] + 1)
            else:
                stack.append([int(id), 0, int(time), 0])
        return res