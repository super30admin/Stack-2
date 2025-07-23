#Time Compelxity: o(n)
#Space Complexity:o(n)
class Solution(object):
    def exclusiveTime(self, n, logs):
        """
        :type n: int
        :type logs: List[str]
        :rtype: List[int]
        """
        res = [0] * n
        stack = []
        prev, cur = 0, 0
        for log in logs:
            data = log.split(":")
            func_id = int(data[0])
            cur = int(data[2])
            if data[1] == "start":
                if len(stack) > 0:
                    res[stack[-1]] += cur - prev
                stack.append(func_id)
                prev = cur
            else:
                res[stack.pop()] += cur + 1 - prev
                prev = cur + 1

        return res



        