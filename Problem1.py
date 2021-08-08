# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# use stack to keep track of previous times

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        
        result = [0]*n
        
        if logs == None or len(logs) == 0:
            return result
        
        st = []
        
        prev = 0
        
        for log in logs:
            
            strings = log.split(":")
            
            curr = int(strings[2])
            
            if strings[1] == "start":
                if len(st) != 0:
                    result[st[len(st)-1]] += (curr-prev)
                    prev = curr
                st.append(int(strings[0]))
            
            else:
                result[st.pop()] += curr+1-prev
                prev = curr + 1
        
        
        return result
                
                
        