class Solution:
    # monotonic stack
    # TC : O(m) -- m is no of logs
    # SC : O(m) 
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        if n == 0:
            return []
        res = [0]*n
        cur,prev = 0,0
        st = []
        for log in logs:
            
            function_id, status, timestamp = log.split(":")
            cur = int(timestamp)
            if status == "start":
                if len(st) > 0:
                    res[st[-1]] += cur - prev
                st.append(int(function_id))
                prev = cur
            else:
                res[st.pop()] += cur-prev+1
                prev = cur +1
        return res