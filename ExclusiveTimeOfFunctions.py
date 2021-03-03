class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        # Time, Space Complexity: O(n)
        st = []
        o = [0 for i in range(0,n)]
        
        for i in range(0,len(logs)):
            p,a,t = logs[i].split(":")
            t = int(t)
            p = int(p)
            if(a=="start"):
                if(len(st)>0):
                    # there will be n+1 slots for n time
                    o[st[-1][0]] += t-1 +1 - st[-1][2]
                    #top of the stack has runtime upto t-1
                    st[-1][2] = t-1
                st.append([p,a,t])
            else:
                p1,a1,t1 = st.pop()
                o[p1] += t +1 - t1
                if(len(st)>0):
                    # top of the stack will start from t+1
                    st[-1][2] = t+1
        return o
