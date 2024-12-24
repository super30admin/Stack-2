class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        result = [0] * n
        stack = []
        prev = 0

        for log in logs:
            split_arr = log.split(":")
            process_id = int(split_arr[0])
            log_type = split_arr[1]
            curr = int(split_arr[2])

            if log_type == "start":
                if stack:
                    result[stack[-1]] += curr - prev
                stack.append(process_id)
                prev = curr
            else:
                curr += 1
                result[stack.pop()] += curr - prev
                prev = curr
        return result

    # time complexity is O(logs+chars in logs)
    # space complexity is O(n) where n is length of result
