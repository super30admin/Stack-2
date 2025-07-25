# TimeComplexity:O(n)
# SpaceComplecity:O(n)
# Approach: we pileup time required for each task we dontknwo whenit will end but every time task runs we add time , when it ends we also add1 as thend is also included


class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        prev,curr=0,0
        ans=[0 for _ in range(n)]
        st=[]
        for log in logs:
            s=log.split(":")
            idl=int(s[0])
            curr=int(s[2])
            if s[1]=='start':
                print(curr-prev)
                if len(st):
                    ans[st[-1]]+=curr-prev
                prev=curr
                st.append(idl)
            else:
                 ans[st.pop()]+=curr-prev+1
                 prev=curr+1
        return ans

