"""
Runtime Complexity: O(n+m) - where 'n' is the number of process and 'm' is the number of logs. We create a result array of size n and perform operations based on 'm' logs.
Space Complexity: O(m) - where m is the number of logs. Stack space.
Yes, the code worked on leetcode.
Issues while coding - No
"""


class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        if n == 0:
            return []
        st = []
        result = [0 for i in range(n)]
        curr,prev = 0,0
        for log in logs:
            splitArray = log.split(":")
            curr = int(splitArray[2])
            if splitArray[1]=="start":
                if st:
                    result[st[len(st)-1]]+=curr-prev
                
                func_id = int(splitArray[0])
                st.append(func_id)
                prev = curr
            else:
                result[st.pop()]+=curr+1-prev
                prev = curr+1
        return result