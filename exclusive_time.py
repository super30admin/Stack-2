"""
Think of this problem as the valid parenthesis "(" is the start of process and ")" is the end of process. Thus,
we need to keep track of order that could be done using stack.
Also, we need to keep track of the previous time based on the start and end. If the task ends at time t that means we
need to add 1. meaning if the task ends at 6, that means it consumed time between 5 and six, units.
TC: O(n) and SC: O(n/2) because the task has to end.
"""


class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:

        stack = []
        ans = [0 for _ in range(n)]
        prev_ts = 0
        for idx, log in enumerate(logs):
            task = log.split(":")
            task_id, task_type, curr_ts = int(task[0]), task[1], int(task[2])

            if task_type == "start":
                # store the task id to maintain order
                # if a new process starts pause the previous one
                if stack:
                    top_stack_task_id = stack[-1]
                    ans[top_stack_task_id] += curr_ts - prev_ts

                # no previous process
                # always adds the start task to the stack
                stack.append(task_id)

            else:
                # if end process
                # this is because if a task end at t it means is used 1 unit time.
                curr_ts = curr_ts + 1
                top_stack_task_id = stack.pop()
                ans[top_stack_task_id] += curr_ts - prev_ts

            prev_ts = curr_ts

        return ans


