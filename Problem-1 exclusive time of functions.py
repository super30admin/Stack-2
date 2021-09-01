class Solution:
    def exclusiveTime(self, n: int, logs) :
        prev = 0
        stack = []
        result = [0 for i in range(n)]

        for i in range(len(logs)):
            entry = logs[i].split(":")
            curr = int(entry[2])
            if entry[1] == "start":
                if stack:
                    result[stack[-1]] += curr - prev
                    prev = curr
                stack.append(int(entry[0]))
            else:
                result[stack.pop()] += (curr + 1) - prev
                prev = curr + 1
        return result