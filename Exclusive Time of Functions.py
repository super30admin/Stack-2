# Time Complexity: O(n)
# Space Complexity: O(n)

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        if not logs:
            return [0]
        
        ans = [0 for _ in range(n)]
        
        curr = 0
        prev = 0
        stack = []

        for log in logs:
            data = log.split(':')
            task = int(data[0])
            curr = int(data[2])

            if data[1] == 'start':
                if stack:
                    ans[stack[-1]] += curr - prev
                stack.append(task)
                prev = curr

            else:
                ans[stack.pop()] += curr +1 - prev
                prev = curr + 1

        return ans