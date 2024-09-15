'''
Accepted on leetcode(636)
time - O(N)
space - O(N)
Approach -
1. Declare a result array and a stack. Also declare curr and prev times.
2. Iterate over given logs array. Split each list item as it is a string.
3. Update curr_time pointer. Check 2 conditions if it is start or end. Based on that update result.
'''


class Solution:
    def exclusiveTime(self, n: int, logs):
        # declaring variables
        prev = 0
        curr = 0

        result = [0 for i in range(n)]
        stack = []

        for s in logs:
            log = s.split(":")  # ['0','start','0']
            curr = int(log[2])  # put time
            if log[1] == 'start':
                if stack:
                    result[stack[-1]] += curr - prev
                stack.append(int(log[0]))  # append function name.
                prev = curr
            else:  # for end times
                result[stack.pop()] += curr - prev + 1
                prev = curr + 1
        return result