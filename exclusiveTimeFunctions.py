from typing import List


class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:

        if logs is None or len(logs) == 0: return None

        callstack = []
        result = [0] * n
        prev = 0

        for log in logs:
            jobdetail = log.split(":")
            current = int(jobdetail[2])
            if jobdetail[1].__contains__('start'):
                if callstack.__len__() > 0:
                    result[callstack[-1]] += current - prev
                    prev = current

                callstack.append(int(jobdetail[0]))
            else:
                result[callstack.pop()] += current - prev + 1
                prev = current + 1

        return result


n = 1
logs = ["0:start:0", "0:start:2", "0:end:5", "0:start:6", "0:end:6", "0:end:7"]

print(Solution().exclusiveTime(n=n, logs=logs))