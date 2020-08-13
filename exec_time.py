from collections import deque
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        prev, curr = 0, 0
        stack = deque()
        result = [0 for _ in range(n)]
        for strings in logs:
            record = strings.split(':')
            curr = int(record[2])
            if record[1] == 'start':
                if stack:
                    result[stack[-1]]+=curr-prev
                stack.append(int(record[0]))
                prev = curr
            else:
                result[stack[-1]]+=curr-prev+1
                stack.pop()
                prev = curr+1
        return result

#time complexity - O(n)

#space complexity - O(n)

#all test cases passed