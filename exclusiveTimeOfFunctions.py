class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        # T: O(n), S: O(n)
        result = [0] * n
        stack = []
        prev_time = 0

        for log in logs:
            func_id, typ, timestamp = log.split(":")
            func_id, timestamp = int(func_id), int(timestamp)

            if typ == "start":
                if stack:
                    result[stack[-1]] += timestamp - prev_time
                stack.append(func_id)
                prev_time = timestamp
            else:  # "end"
                result[stack.pop()] += timestamp - prev_time + 1
                prev_time = timestamp + 1

        return result
