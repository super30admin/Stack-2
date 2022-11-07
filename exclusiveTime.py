#Time: O(n)
#Space: O(n)
#Program ran on leetcode successfully

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        prev = 0
        curr = 0
        st = []
        res = [0] * n
        
        for log in logs:
            arr = log.split(":")
            curr = int(arr[2])
            
            if arr[1] == "start":
                if st:
                    res[st[-1]] += curr - prev
                st.append(int(arr[0]))
                prev = curr
            else:
                res[st[-1]] += curr - prev + 1
                st.pop()
                prev = curr + 1
        
        return res
                
        