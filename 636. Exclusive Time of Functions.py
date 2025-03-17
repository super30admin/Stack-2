#time:O(n)
#Space: O(n)- stack for keeping track of ongoing processes

#approach: here we are using a stack and a prev variable to check which process is the last one and when did it started or when did the last process ended

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        arr=[0]*n
        st=[]
        prev=0
        for log in logs:
            fn,process,time=log.split(':')
            time=int(time)
            fn=int(fn)
            if process == 'start':
                if len(st)!=0:
                    arr[st[-1]]+=time-prev
                st.append(fn)
                prev=time
            else:
                arr[st.pop()]+=time-prev+1
                prev=time+1
        return arr
