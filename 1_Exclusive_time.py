// Time Complexity : O(n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        
        result=[0 for i in range(0,n)]
        
        stack=[]
        prev_time=0

        for i in logs:

            s=i.split(":")

            taskid=int(s[0])
            action=s[1]
            current_time=int(s[2])

            # print(taskid,action,current_time)
            if action== 'start':
                if len(stack)>0:
                    result[stack[-1]]=result[stack[-1]]+(current_time-prev_time)

                stack.append(taskid)
                prev_time=current_time

            else:
                    val=stack.pop()
                    result[taskid]=result[taskid]+(current_time-prev_time)+1
                    prev_time=current_time+1
        return result