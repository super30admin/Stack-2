# Time Complexity : O(k) k = logs
# Space Complexity : O(n)


from typing import List

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:

        if logs is None or len(logs) == 0:
            return []

        res = [0] * (n)
        st = []
        prev = 0

        for i in logs:
            fid, a, t = i.split(":")
            if a == "start":
                if st:
                    res[st[-1]] += int(t) - prev
                prev = int(t)
                st.append(int(fid))
            else:
                res[st[-1]] += int(t) - prev + 1
                prev = int(t) + 1
                st.pop()

        return res
