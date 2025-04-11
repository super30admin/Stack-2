#Time Complexity: O(L)
#Space Complexity: O(N + L) Where L is the number of logs and N is the number of functions.
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        result = [0] * n
        stack = []
        prev = 0
        for log in logs:
            splitarr = log.split(":")
            processID = int(splitarr[0]) 
            Type = splitarr[1]
            curr = int(splitarr[2])
            if(Type=="start"):
                if(len(stack)>0):
                    result[stack[-1]] += curr - prev
                stack.append(processID)
            else:
                curr = curr+1
                result[stack.pop()] += curr - prev 
            prev = curr
        return result
                    

        