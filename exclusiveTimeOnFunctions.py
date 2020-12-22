#Time Complexity : O(n)
#Space Complexity : O(n)
#Did this code successfully run on Leetcode : Yes

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        if not logs:
            return []
        prev = 0
        stack = []
        result = [0] * n

        #iterate through all logs
        for log in logs:
            task, t, curr = log.split(":")
            #if task is start
            if t == "start":
                if stack:
                    result[stack[-1]] += int(curr) - prev
                    prev = int(curr)
                stack.append(int(task))
            #if task is end
            else:
                result[stack.pop()] += int(curr) - prev + 1
                prev = int(curr) + 1


        return result
