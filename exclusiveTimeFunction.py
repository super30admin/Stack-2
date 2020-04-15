'''
Time Complexity: O(n)
Space Complexity:O(n)
Did this code successfully run on Leetcode : Yes
Explanation: Create a stack and if we see a start for the function - >push the functionId into the stack while saving
the currentTimestamp - priorTimestamp into the result array and if we see an end we pop the top of stack (as it contains
the currently executing function) and update the time its been running by currentTimestamp - priorTimestamp + 1 and
update the priorTimestamp by currentTimestamp+1
'''
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        stack = []
        res = [0 for i in range(n)]
        priorTimestamp = 0
        for log in logs:
            token = log.split(':')
            functionId = int(token[0])
            currentTimestamp = int(token[2])
            if token[1] == "start":
                if len(stack) != 0:
                    res[stack[-1]] += currentTimestamp - priorTimestamp
                stack.append(functionId)
                priorTimestamp = currentTimestamp
            else:
                res[stack.pop()] += currentTimestamp - priorTimestamp + 1
                priorTimestamp = currentTimestamp + 1

        return res