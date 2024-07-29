# Time Complexity : O(l), where l is the number of log entries
# Space Complexity : O(l), for the stack
from typing import List

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        if n == 0 or not logs:
            return []
        
        result = [0] * n
        stack = []
        prev = -1
        
        for log in logs:
            log_split = log.split(":")
            id = int(log_split[0])
            label = log_split[1]
            cur = int(log_split[2])

            if label == "start":
                if stack:
                    result[stack[-1]] += cur - prev
                stack.append(id)
                prev = cur
            else:
                result[stack.pop()] += cur - prev + 1
                prev = cur + 1

        return result

# Examples
sol = Solution()

# Example 1
n1 = 2
logs1 = ["0:start:0", "1:start:2", "1:end:5", "0:end:6"]
print("Example 1: n =", n1, "logs =", logs1)
print("Output:", sol.exclusiveTime(n1, logs1))
# Expected Output: [3, 4]

# Example 2
n2 = 1
logs2 = ["0:start:0", "0:end:2"]
print("Example 2: n =", n2, "logs =", logs2)
print("Output:", sol.exclusiveTime(n2, logs2))
# Expected Output: [3]

# Example 3
n3 = 2
logs3 = ["0:start:0", "0:end:1", "1:start:2", "1:end:3"]
print("Example 3: n =", n3, "logs =", logs3)
print("Output:", sol.exclusiveTime(n3, logs3))
# Expected Output: [2, 2]