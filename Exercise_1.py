# Problem1 Exclusive Time of Functions (https://leetcode.com/problems/exclusive-time-of-functions/)
# // Time Complexity :
# // Space Complexity :
# // Did this code successfully run on Leetcode :
# // Any problem you faced while coding this :


# // Your code here along with comments explaining your approach
class Solution:
    def exclusiveTime(self, n, logs):
        # using stack
        stack = []
        # result list
        result = [0] * n
        # prev for previous ts
        prev = 0
        # going through the logs
        for log in logs:
            # splitting the string
            arr = log.split(':')
            task_id = int(arr[0])
            function = arr[1]
            curr_time_stamp = int(arr[2])
            if function == 'start':
                # pausing the previous function if any
                # recording its time
                if stack:
                    duration = curr_time_stamp - prev
                    # adding it to top element of stack since not ended
                    result[stack[-1]] += duration
                # pushing it to stack
                stack.append(task_id)
                # updating prev
                prev = curr_time_stamp
            else:
                if stack:
                    # curr_time_stamp + 1 for effective time
                    duration = curr_time_stamp + 1 - prev
                    # popping out the last element coz ended
                    result[stack.pop()] += duration
                prev = curr_time_stamp + 1
        return result


n = 2
logs = ["0:start:0", "1:start:2", "1:end:5", "0:end:6"]
sol = Solution()
print(sol.exclusiveTime(n, logs))
