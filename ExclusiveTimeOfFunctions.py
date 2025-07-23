# // Time Complexity : o(n) number of logs
# // Space Complexity : o(n) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach
# We use a stack to track which function is running at any given time.
# If a function starts, we pause the previous one and calculate how much it ran.
# When a function ends, we pop it and add its exclusive duration, adjusting for time units.


from typing import List
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        res = [0]*n
        st = []
        prev = 0
        for log in logs:
            splitarr = log.split(":")
            prid = int(splitarr[0])
            prtype = splitarr[1]
            curr = int(splitarr[2])
            if prtype == "start":
                if st:
                    res[st[-1]]+=curr-prev
                st.append(prid)
            else:
                curr+=1
                popped = st.pop()
                res[popped]+=curr-prev
            prev = curr
        return res
