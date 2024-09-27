#Leetcode : Pass
#SC- O(1),TC-O(n)
#1)if start - push function to stack, update the prev time, also update the time slots for the particular function
#2) if end - calculate the time slots, update the prev time
class Solution:
    def exclusiveTime(self, n: int, logs):
        curr_time =0
        prev_time =0
        stack =[]
        result = [0]*n
        for l in logs:

            log = l.split(":")
            curr_time = int(log[2])
            #1
            if log[1] == 'start':
                if len(stack) != 0:
                    result[stack[-1]] += curr_time - prev_time
                prev_time = curr_time
                stack.append(int(log[0]))
            #2
            else:
                result[stack.pop()] += curr_time - prev_time +1
                prev_time = curr_time+1
        return result

obj = Solution()
obj.exclusiveTime(2,["0:start:0","1:start:2","1:end:5","0:end:6"])
