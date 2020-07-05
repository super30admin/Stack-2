#Time Complexity : O(N) where N is number of elemeents
#Space Complexity :O(N) where N is number of elemtns stored
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        finalResult = [0 for x in range(n)]
        st = []
        priorTime = 0
        currentTime = 0
        if logs == None or len(logs) == 0:
            return finalResult
        
        for log in logs:
            logSplit = log.split(':')
            functionId = int(logSplit[0])
            event = logSplit[1]
            timeStamp = int(logSplit[2])
            
            currentTime = timeStamp
            
            if (event == 'start'):
                if (len(st) > 0):
                    finalResult[st[-1]] += (currentTime - priorTime)
                st.append(functionId)
                priorTime = currentTime
            
            else:
                finalResult[functionId] += (currentTime - priorTime + 1)
                st.pop()
                priorTime = currentTime + 1
            
        return finalResult
             