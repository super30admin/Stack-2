# Time complexity - O(n)
#  Space complexity - O(n)
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        if len(logs) == 0:
            return [0]
        st=[]
        c,p=0,0
        res=[0]*(n)
        for log in logs:
            out=log.split(":")
            c=out[2]
            c_id=out[0]
            if out[1] == "start":
                if(st != []):
                    res[int(st[-1])]+= int(c)-int(p)
                st.append(int(c_id))
                p=c
            else:
                res[st.pop()]+=int(c)+1-int(p)
                p=int(c)+1
        return res