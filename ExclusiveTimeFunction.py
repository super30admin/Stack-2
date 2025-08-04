class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        result = [0]*n
        stack = []
        prev = 0

        for log in logs:
            func_id_str, typ, time_str = log.split(":")
            func_id = int(func_id_str)
            curr = int(time_str)

            if typ == 'start':
                if stack:
                    result[stack[-1]] += curr - prev
                stack.append(func_id)
                prev = curr
            else:
                result[stack.pop()] += curr - prev + 1
                prev = curr + 1
        return result