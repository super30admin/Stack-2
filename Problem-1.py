'''
    Time Complexity: O(m)
    Space Complexity: O(m)
'''
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        call_stack = []
        result = [0 for _ in range(n)]

        for log in logs:
            id, status, timestamp = log.split(":")
            id = int(id)
            timestamp = int(timestamp)

            if status == "start":
                if len(call_stack):
                    prev_id, prev_start = call_stack[-1]
                    result[prev_id] += timestamp - prev_start

                call_stack.append([id, timestamp])
            else:
                prev_id, prev_start = call_stack[-1]
                result[prev_id] += timestamp - prev_start + 1
                call_stack.pop()
                
                if len(call_stack):
                    call_stack[-1][1] = timestamp + 1

        return result
                
