# TC - O(n)
# SC - O(n)
class Solution(object):
    def exclusiveTime(self, n, logs):
        """
        :type n: int
        :type logs: List[str]
        :rtype: List[int]
        """

        prev = 0
        stack = []
        result = [0] * n

        for log in logs:
            log = log.split(":")
            pid = int(log[0])
            call = log[1]
            time = int(log[2])

            curr = time

            if call == "start":
                if stack:
                    result[stack[-1]] += curr - prev
                prev = curr
                stack.append(pid)
            else:
                result[stack.pop()] += curr - prev + 1
                prev = curr + 1

        return result
