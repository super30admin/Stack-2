# Time Complexity : O(n + mk) n-> num functions m-> len of logs k-> avg len of log string
# Space Complexity : O(m/2)
# Did this code successfully run on Leetcode : YES

# Any problem you faced while coding this : NO

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        times = [0] * n

        stack = []

        for log in logs:
            id, op, time = log.split(":")
            id = int(id)
            time = int(time)
            if op == "start":
                if stack: # then pause the prev and process the time elapsed
                    elapsed = time - stack[-1][1]
                    times[stack[-1][0]] += elapsed
                stack.append([id, time])
            else: # op is end
                prev_id, st_time = stack.pop()
                if prev_id == id:
                    elapsed = time - st_time + 1
                    times[id] += elapsed
                if stack: # update the start time of prev fn id in stack
                    stack[-1][1] = time + 1
                
        return times