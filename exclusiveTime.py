"""
Use a stack to simulate function calls; each stack element tracks the current active function
For every start, pause the current function (if any) and push the new one
For every end, pop from the stack and calculate the time spent, then resume the caller
"""
"""
Time Complexity - O(L) N = Number of functions , L = Number of logs
Space Complexity - O(N + L)	Stack in worst case (all open brackets)
"""

class exclusiveTime:
    def exclusiveTimes(self, n: int, logs: list[str]) -> list[int]:
        result = [0] * n
        stack = []
        prev_time = 0

        for log in logs:
            fn_id, typ, time = log.split(":")
            fn_id, time = int(fn_id), int(time)

            if typ == "start":
                if stack:
                    result[stack[-1]] += time - prev_time
                stack.append(fn_id)
                prev_time = time
            else:  # end
                result[stack.pop()] += time - prev_time + 1
                prev_time = time + 1

        return result

if __name__ == "__main__":
    obj = exclusiveTime()
    print(obj.exclusiveTimes(2, ["0:start:0", "1:start:2", "1:end:5", "0:end:6"]))  # [3, 4]
    print(obj.exclusiveTimes(1, ["0:start:0", "0:end:0"]))                          # [1]
    print(obj.exclusiveTimes(2, ["0:start:0", "0:end:2", "1:start:3", "1:end:4"]))  # [3, 2]
