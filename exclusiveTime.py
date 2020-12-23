"""
Time complexity O(Size of logs)
Space complexity O(N)


"""
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        if not logs:
            return [0]
        
        st=[]
        res=[0]*n
        prev=0
        for log in logs:
            splitlog=log.split(':')
            #['1', 'start', '2'] [id:st/end:timestamp]
            curr=int(splitlog[2])
            if(splitlog[1]=='start'):
                if st:
                    res[st[-1]]+=curr-prev
                    prev=curr
                st.append(int(splitlog[0]))
            else:
                res[st.pop()]+=curr-prev+1
                prev=curr+1
        return res
                