# S30 Problem #135 Exclusive Time of Functions
#LeetCode #636. https://leetcode.com/problems/exclusive-time-of-functions/description/

# Author : Akaash Trivedi
# Did this code successfully run on Leetcode :  Yes #
# Any problem you faced while coding this : No

# stack to track all function_id running at given time
# new function start, calculate the time for prevous function
# function end pop it out from top of the stack and cal execution time and add one to it (end inclusive)
# time complexity: O(len(log))
# space complexity O(len(log))
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        st = []
        res = [0]*n
        prevTime = 0
        for log in logs:
            splt = log.split(":")
            pId = int(splt[0])
            ptype = splt[1]
            currTime = int(splt[2])

            if ptype == "start":
                # calculate the time of current top of stack process
                if st:
                    res[st[-1]] += currTime - prevTime
                # add new process to stack
                st.append(pId)
            else:
                popped = st.pop() #pop out when end
                currTime = currTime +1 # when its end we add 1 (inclusive of end)
                res[popped] += currTime - prevTime
            prevTime = currTime
        return res