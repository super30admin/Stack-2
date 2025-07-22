"""
I implemented the solution using a stack to track active function calls. For each log, if the process is 'start', I update the running time of the function on top of the stack (if any), then push the new function onto the stack. If the process is 'end', I pop the function from the stack and add its total execution time. The variable prevTime helps track the last processed timestamp for accurate duration calculation.
Time Complexity: O(n)
Space Complexity: O(n)
"""
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        result = [0] * n
        stack = []
        prevTime = 0
        for log in logs:
            funcID, process, time = log.split(":")
            funcID, time = int(funcID), int(time)

            if process == "start":
                if stack:
                    result[stack[-1]] += time - prevTime
                stack.append(funcID)
                prevTime = time
            else:
                result[stack.pop()] += time - prevTime + 1
                prevTime = time + 1
        return result