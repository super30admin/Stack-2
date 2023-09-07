# Time Complexity :O(N) N= log size
# Space Complexity :O(N) N= Log size
# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this :

# Your code here along with comments explaining your approach


from collections import deque


class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        st=deque()
        result=[0 for i in range(n)]
        m=len(logs)
        prev=0
        for i in range(m):
            pid, status, stamp=logs[i].split(":")
            curr=int(stamp)
            # popped_id, popped_status, popped_stamp=st[-1].split(":")
            if(status=='start'):
                if(len(st)):
                    popped_id, popped_status, popped_stamp=st[-1].split(":")
                    result[int(popped_id)]+=curr-prev
                st.append(logs[i])
                prev=curr
            else:
                popped_id, popped_status, popped_stamp=st.pop().split(":")
                result[int(popped_id)]+=curr-prev+1
                prev=curr+1

        return result