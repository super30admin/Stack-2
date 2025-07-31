class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        res=[0]*n
        log=logs[0].split(':')
        stack=[]
        stack.append(int(log[0]))
        for idx, log in enumerate(logs):
            l=log.split(':')
            if idx==0:
                prev=l
                continue
            
            if l[1]=='start':
                if prev[1]=='start':
                    res[int(prev[0])]+=int(l[2])-int(prev[2])
                else:
                    if stack:
                        res[stack[-1]]+=int(l[2])-int(prev[2])-1
                stack.append(int(l[0]))
            
            else:
                stack.pop()
                if prev[1]=='start':
                    res[int(l[0])]+=int(l[2])-int(prev[2])+1
                    #res[prev[0]]+=l[2]-prev[2]
                else:
                    res[int(l[0])]+=int(l[2])-int(prev[2])
        
            prev=l
        
        return res
