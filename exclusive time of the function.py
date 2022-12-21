# TC:O(N)
# SC:O(N)

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        res=[0]*n

        stack=[]

        if not logs:
            return [0]

        prev=cur=0

        for log in logs:

            data=log.split(":")
            task=int(data[0])
            cur=int(data[2])

            if data[1]=="start":
                if stack:
                    res[stack[-1]]+=cur-prev
                
                stack.append(task)
                prev=cur

            else:
                res[stack.pop()]+=cur+1-prev

                prev=cur+1
        return res