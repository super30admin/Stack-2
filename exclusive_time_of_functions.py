# Time Complexity :
# O (N)

# Space Complexity :
# O(N)

# Did this code successfully run on Leetcode :
#Yes

#We go through each log one at a time. We also store a result array initlized by 0s
#Every time we see a new log, if it is a start log, we update the stack's top element's time by current start time - previous start time and add new start to the stack
#If it is an end, we update the stack's top element's time by current time - prev start time + 1 and update the prev start time to current time + 1(since the start time should be correspoing to the next step)
#In the end we, return the result

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        result = [0] *n
        stack = collections.deque()
        prev_time = 0

        for log in logs :
            curr_info = log.split(":") 
            curr_id = int(curr_info[0])
            curr_time = int(curr_info[-1])

            if curr_info[1] == 'start' :
                if len(stack) != 0 :
                    result[stack[-1]] += curr_time - prev_time
                stack.append(curr_id)
                prev_time = curr_time

            elif curr_info[1] == 'end' :
                last_elem = stack.pop()
                result[last_elem] += (curr_time - prev_time) + 1
                prev_time = curr_time + 1

        return result
