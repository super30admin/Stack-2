# Created by Aashish Adhikari at 5:31 PM 3/3/2021
'''
Time Complexity:
O(n)

Space Complexity:
O(n)
'''

class Solution(object):
    def exclusiveTime(self, n, logs):
        """
        :type n: int
        :type logs: List[str]
        :rtype: List[int]
        """

        sol = [0 for _ in range(n)]

        from collections import deque

        stack = deque()

        prev_event_time = 0

        for idx in range(0, len(logs)):

            log = logs[idx]

            splitt = log.split(":")
            id_ , START, timestamp = int(splitt[0]), splitt[1], int(splitt[2])

            if START == "start":
                if len(stack) != 0:
                    stack_top = stack[-1]


                    sol[stack_top] += timestamp - prev_event_time
                    prev_event_time = timestamp

                stack.append(id_)

            else:
                stack_top = stack.pop()
                sol[stack_top] += timestamp - prev_event_time + 1
                prev_event_time = timestamp + 1





        return sol