#TC: O(n)
#SC: O(n)

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        stack=[]
        res=[0]*n
        prev=0
        for i in logs:
            ss=i.split(":")
            curr = int(ss[2])
            if ss[1]=="start":              
                if stack:
                    res[stack[-1]] += curr - prev
                stack.append(int(ss[0]))
                prev=curr
            else:                           
                res[stack.pop()]+=(curr+1)-prev
                prev=curr+1
        return res