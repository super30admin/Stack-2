# Time Complexity: O(m), where m is the num of entries in logs
# Space Complexity: O(m)

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        if n == 0 or not logs or len(logs) == 0:
            return []

        result = [0 for x in range(n)]
        stack = []
        prev = 0

        for log in logs:
            # Split each log to get the func_id, start/end and timestamp
            str_arr = log.split(":")
            curr = int(str_arr[2])

            # Compute func's the execution time from its start time to next func's start time
            if str_arr[1] == "start":
                if stack:
                    result[stack[-1]] += curr - prev
                    prev = curr
                stack.append(int(str_arr[0]))

            # Compute the remaining execution time as above and add 1 to include ending
            else:
                result[stack.pop()] += curr - prev + 1
                prev = curr + 1

        return result


