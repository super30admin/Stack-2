class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        st=[]
        result=[0]*n
        prev=0

        for log in logs:
            splitArr=log.split(":")
            processId=int(splitArr[0])
            log_type=splitArr[1]
            curr=int(splitArr[2])

            if log_type=="start":
                if st:
                    result[st[-1]]+=curr-prev
                st.append(processId)
            else:
                curr+=1
                result[st.pop()]+=curr-prev
            prev=curr
        return result

        
