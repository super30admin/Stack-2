#Time Complexity:O(n)
#Space Complexity:O(n/2)
# where n is length of logs
#use stack to push process during start into the stack and use curr and prev pointers to calculate the time and add them to the resultant array .
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        if len(logs)==0:
            return []
        result=[0 for i in range(n)]
        st=[]
        prev=0
        for log in logs:
            s=log.split(':')
            curr=int(s[2])
            if s[1]=='start':
                if st:
                    result[st[-1]]+=curr-prev
                    prev=curr
                st.append(int(s[0]))
            else:
                result[st.pop()]+=curr+1-prev
                prev=curr+1
        return result