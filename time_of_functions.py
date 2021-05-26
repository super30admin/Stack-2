# Time Complexity: O(n) 
# Space Complexity: O(n)
# Ran on Leetcode: Yes

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        if not n or not len(logs):
            return []
        prev = 0
        stack = []
        res = [0] * n
        for item in logs:
            arr = item.split(":")
            curr = int(arr[2])
            if arr[1] == "start":
                if len(stack):
                    res[stack[-1]] += curr - prev
                    prev = curr
                stack.append(int(arr[0]))
                
            else:
                res[stack.pop()] += curr - prev + 1
                prev = curr + 1
        return res