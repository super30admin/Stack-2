# TC - O(n)
# SC - O(n)


class Solution:
    def exclusiveTime(self, n, logs):
        res = [0] * n
        stack = []
        prev = 0

        for log in logs:
            split = log.split(":")
            curr = int(split[2])

            if split[1] == "start":
                if stack:
                    res[stack[-1]] += curr - prev
                stack.append(int(split[0]))
                prev = curr
            else:
                res[stack.pop()] += curr - prev + 1
                prev = curr + 1

        return res
