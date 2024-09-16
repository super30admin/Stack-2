# Time Complexity : O(logs)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def exclusiveTime(self, n, logs):
        """
        :type n: int
        :type logs: List[str]
        :rtype: List[int]
        """
        res = [0] * n
        stack = []
        prev = 0
        # iterate over logs
        for log in logs:
            cpuid, func, time = log.split(":")
            # print(stack)
            current = int(time)
            # if it is start and there was another pprocess before it, then update its time
            if func == "start":
                if stack:
                    res[int(stack[-1])] += current - prev
                    prev = current
                stack.append(int(cpuid))
                # if its end then update its time
            else:
                x = stack.pop()
                if x == int(cpuid):
                    res[int(cpuid)] += current - prev + 1
                    prev = current + 1

        return res