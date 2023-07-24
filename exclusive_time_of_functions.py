# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
"""
The code goes through the logs and adds a task that has been started to the stack. When a task is finished it looks for the amount 
of time in the stack before the start of the task and subtracts it from the total time.
"""

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        answer = [0 for i in range(n)]
        stack = []

        for activity in logs:
            task, status, time = activity.split(':')
            task = int(task)
            time = int(time)
            if status == 'start':
                stack.append([task, time])
            else:
                time_in_between = 0
                while True:
                    if type(stack[-1]) == int:
                        time_in_between += stack.pop()
                    else:
                        break
                popped = stack.pop()
                assert popped[0] == task
                answer[task] += time - popped[1] - time_in_between + 1
                stack.append(time - popped[1] + 1)
            print(answer)


        return answer