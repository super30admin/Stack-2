#Time Complexity :O(N) 
#Space Complexity :O(N)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        st=[]
        result=[0]*n
        prev=0
        for log in logs:
            l=log.split(':')
            curr=int(l[2])
            task=int(l[0])
            if l[1]=='start':
                if st:
                    result[st[-1]]+=curr-prev
                st.append(task)
                prev=curr
            else:
                result[st.pop()]+=curr+1-prev
                prev=curr+1
        return result


        