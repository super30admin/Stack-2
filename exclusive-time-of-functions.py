# Time O(m + n)
# Space O(m/2)
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        result = [0] * n
        prev = 0
        stack= []
        for log in logs:
            f_id, s, curr = log.split(':')
            f_id, curr = int(f_id), int(curr)
            if s == 'start':
                if len(stack) > 0:
                    result[stack[-1]] += curr - prev
                stack.append(f_id)
                prev = curr
            else:
                result[f_id] += (curr+1) - prev
                stack.pop()
                prev = curr + 1
        return result