#time complexity: O(n)
#space complexity: O(n)
#ran on leetcode: yes
#have a stack to save function calls which are interupted. Restore them from top of stac
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        stk=[]
        L=[0]*n
        for log in logs:
            index=int(log.split(":")[0])
            job_type=log.split(":")[1]
            time=int(log.split(":")[2])
            if(job_type=="start"):
                if(stk!=[]):
                    old_ind=stk[-1][0]
                    L[old_ind]+=(time-stk[-1][1])
                stk.append((index,time))
            else:
                start_time=stk[-1][1]
                job_no=stk[-1][0]
                L[job_no]+=(time-start_time+1)
                del(stk[-1])
                if(stk!=[]):
                    new_ele=(stk[-1][0],time+1)
                    del(stk[-1])
                    stk.append(new_ele)
        return L
