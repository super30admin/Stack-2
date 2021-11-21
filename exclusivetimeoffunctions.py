"""https://leetcode.com/problems/exclusive-time-of-functions/"""


class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        """
        TC: O(number of logs)
        SC: O(n)
        """
        ###null
        if n == None or logs == None:
            return []
        result = [0] * n
        prev = 0
        stack = []
        for log in logs:
            intermed = log.split(":")
            pid = intermed[0]
            pstate = intermed[1]
            currtime = int(intermed[2])

            if pstate == "start":
                if stack:
                    result[stack[-1]] += currtime - prev
                prev = currtime
                stack.append(int(pid))

            if pstate == "end":
                result[stack.pop()] += currtime + 1 - prev
                prev = currtime + 1
        return result



