# Time Complexity : O(n) going through the times given only once
# Space Complexity : O(n) we are using a stack which can be of size n/2
# runs on leetcode : Yes Perfectly!
# any problems faced : NO

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        res = [0 for _ in range(n)]
        stack = []
        for log in logs:
            data = log.split(':')
            if data[1] == 'start':
                stack.append((int(data[0]), int(data[2])))
            else:
                idx, start = stack.pop()
                time = int(data[2]) - start + 1
                res[idx] += time
			
                if stack:
                    res[stack[-1][0]] -= time
                    print(stack[-1][0])
        return res
        