# Time Complexity : O(n)
# Space Complexity : O(n/2)
class Solution:
    def exclusiveTime(self, n: int, logs):
        stack = []
        res = [0] * n
        prev = 0
        exTime = 0

        for log in logs:
            logArr = log.split(':')
            processId = int(logArr[0])
            process = logArr[1]
            curr = int(logArr[2])

            if process == 'start':
                if stack:
                    prevProcess = stack[-1]
                    res[prevProcess] += curr - prev
                stack.append(processId)
                prev = curr
            elif process == 'end':
                prevProcess = stack.pop()
                res[prevProcess] += (curr + 1) - prev
                prev = curr + 1

        return res