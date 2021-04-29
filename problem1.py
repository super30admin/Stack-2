#time Complexity O(n)
#space Complexity O(n)


class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        stack=deque()
        output=[0 for i in range(n)]
        pre=0
        cur=0
        for log in logs:
            a,b,c=log.split(":")
            cur=int(c)
            if b=="start":
                if stack:
                    output[stack[-1]]+=cur-pre
                    pre=cur
                stack.append(int(a))
                
            else:
                output[stack.pop()]+=cur-pre+1
                pre=cur+1
        return output
        
