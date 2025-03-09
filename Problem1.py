# In this approach, we will use a stack to keep track of the function calls and their start times.
# When we encounter a "start" log, we push the function ID onto the stack and update the previous time.
# When we encounter an "end" log, we pop the function ID from the stack and calculate the exclusive time for that function.
# TC: O(n)
# SC: O(n)


class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        res = [0] * n
        curr = 0
        prev = 0
        s = []
        for log in logs:
            strarr = log.split(':')
            curr = int(strarr[2])
            if strarr[1] == "start":
                if s:
                    res[s[-1]] += curr - prev
                s.append(int(strarr[0]))
                prev = curr
            else:
                res[s.pop()] += curr - prev + 1
                prev = curr + 1

        return res
