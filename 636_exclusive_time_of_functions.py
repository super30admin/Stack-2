from typing import List


class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        """
            https://leetcode.com/problems/exclusive-time-of-functions/
            Time Complexity - O(n)
            Space Complexity - O(n)
            'n' is the number of function functions
        """
        result = [0] * n
        stack = []
        prev_time = 0
        for log in logs:
            fn, typ, cur_time = log.split(':')
            fn, cur_time = int(fn), int(cur_time)

            if typ == 'start':
                if stack:
                    result[stack[-1]] += cur_time - prev_time
                stack.append(fn)
                prev_time = cur_time
            else:
                result[stack.pop()] += cur_time - prev_time + 1
                prev_time = cur_time + 1
        return result


if __name__ == '__main__':
    print(Solution().exclusiveTime(2, ["0:start:0", "1:start:2", "1:end:5", "0:end:6"]))
