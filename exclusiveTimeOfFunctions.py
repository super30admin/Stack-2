# // Time Complexity :O(n) 
# // Space Complexity : O(k) k is total number of logs
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Else statement pop is in the result location


# // Your code here along with comments explaining your approach

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        st = []                                 # stack stores process
        res = [0] * n                           # array stores result
        prev = 0

        for log in logs:
            splitArr = log.split(':')
            process = int(splitArr[0])
            ptype   = splitArr[1]
            curr    =  int(splitArr[2])
            
            if ptype == 'start':                              # start process
                if st:
                    res[st[-1]] += curr - prev                # peek top element for start
                st.append(process)

            else:                                             # end process
                curr = curr + 1                                     # end time is next start time
                res[st.pop()] += curr - prev                  # pop top element for end

            prev = curr                                       # update curr

        return res