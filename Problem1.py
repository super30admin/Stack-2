class Solution:
    # Time Complexity: O(n)
    # Space Complexity: O(n)
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        stack = []
        result = n * [0]
        prev = 0
        for i in range(len(logs)):
            log = logs[i].split(":")
            curr = int(log[2])
            if log[1] == "start":
                if stack:
                    result[stack[-1]] += curr - prev
                stack.append(int(log[0]))
                prev = curr
            elif log[1] == "end":
                result[stack.pop()] += curr - prev + 1
                prev = curr + 1
        return result
