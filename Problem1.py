"""
// Time Complexity : o(n), n->number of logs
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
"""

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        if not logs:
            return []

        st = [] #maintining active functions
        prev = 0 #maintaining prev interval 
        res = [0] * n #

        for log in logs: #for each log
            str_arr = log.split(":")
            curr = int(str_arr[2]) #current interval
            
            if str_arr[1] == "start": 
                if st: #if its not the first interval
                    res[st[-1]] += curr - prev #add running till now for the prev function id
                
                st.append(int(str_arr[0])) #add curr id to stack
                
                prev = curr #update prev
                
            else: #end case
                res[st.pop()] += curr - prev + 1 #pop and add the time for which the function ran to res
                prev = curr + 1 #update prev
                
        return res