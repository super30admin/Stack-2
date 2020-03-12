from typing import List


class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        """
            https://leetcode.com/problems/exclusive-time-of-functions/
            Time Complexity - O(n)
            Space Complexity - O(n)
            'n' is the number of function functions
        """
        ans = [0] * n
        stack = []
        prev_time = 0
        for log in logs:
            fn, typ, time = log.split(':')
            fn, time = int(fn), int(time)

            if typ == 'start':
                if stack:
                    ans[stack[-1]] += time - prev_time
                stack.append(fn)
                prev_time = time
            else:
                ans[stack.pop()] += time - prev_time + 1
                prev_time = time + 1
        return ans


if __name__ == '__main__':
    print(Solution().exclusiveTime(2, ["0:start:0", "1:start:2", "1:end:5", "0:end:6"]))
