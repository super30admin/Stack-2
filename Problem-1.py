class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        stack=[]
        prev=0
        curr=0
        output=[0 for i in range(n)]
        
        for log in logs:
            log_split=log.split(':')
            curr=int(log_split[2])
            if log_split[1]=='start':
                if len(stack)>0:
                    output[int(stack[-1])]+=curr-prev
                    prev=curr
                stack.append(log_split[0])
            
            elif log_split[1]=='end':
                output[int(stack.pop())]+=curr-prev+1
                prev=curr+1
                
        return output
                
        
        
        