#Time complexity: O(n)
#Space complexity: O(n)

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        res = [0 for _ in range(n)]
        prev = 0
        
        st = []
        
        for log in logs:
            log = log.split(':')
            curr = int(log[2])
            if log[1] == "start":
                if st:
                    res[st[-1]] += curr - prev
                prev = curr
                st.append(int(log[0]))
            else:
                res[st.pop()] += curr + 1 - prev
                prev = curr + 1
        return res
                
                
                
            
            
            
        
