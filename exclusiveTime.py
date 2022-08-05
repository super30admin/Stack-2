# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:

        res = [0] * n

        stack = []

        cur = 0

        for log in logs:

            fid, state, timestamp = log.split(":")

            fid = int(fid)
            timestamp = int(timestamp)

            if state == "end":
                stack.pop()
                res[fid] += timestamp - cur + 1
                cur = timestamp + 1
            else:
                if (stack):
                    fidprev, time = stack[-1]

                    res[fidprev] += timestamp - cur

                stack.append((fid, timestamp))

                cur = timestamp

        return res
