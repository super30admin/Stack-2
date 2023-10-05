'''
1. Maintain a stack and a time_elapsed variable to keep track of current time
2. If the type of log is start then we check if another process is already in the stack. We update the previous processes time by adding the timestamp - time_elapsed
3. We push the current process into the stack and update the time_elapsed.
4. If the type of log is end, we pop the stack and update the time of the current process by adding the current time - time_elapsed + 1 

Time Complexity: O(n)
Space Complexity: O(n) - Stack
'''

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:

        num_logs = len(logs)
        ans = [0]*n
        stack = []
        time_elapsed = 0
        for log in range(num_logs):
            function_id,log_type,timestamp = logs[log].split(':')
            function_id = int(function_id)
            timestamp = int(timestamp)

            if log_type == 'start':
                if stack:
                    prev_fid,prev_time = stack[-1]
                    ans[prev_fid] += timestamp - time_elapsed 
                stack.append((function_id,timestamp))
                time_elapsed = timestamp

            else:
                stack.pop()
                ans[function_id] += timestamp-time_elapsed+1
                time_elapsed = timestamp + 1
        return ans