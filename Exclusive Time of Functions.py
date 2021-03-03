#time: O(len(logs))
#space: O(len(logs))

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        if(logs==[]):
            return []
        stack=[]
        result=[0]*n
        prev=0
        curr=0
        for log in logs:
            s=log.split(":")
            taskid=int(s[0])
            task=s[1]
            tasktime=int(s[2])
            if(task=="start"):
                curr=tasktime
                if(stack!=[]):
                    result[stack[-1]]+=curr-prev
                    prev=curr
                stack.append(taskid)
            else:
                curr=tasktime
                result[stack.pop()]+=curr+1-prev
                prev=curr+1
        return result
                
            
            
            
            
        