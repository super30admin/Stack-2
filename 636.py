class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        if n == 0:
            return ""
        result = [0]*n
        stack1 = []
        curr = 0
        prev = 0
        for log in logs:
            strarray = log.split(":") 
            curr = int(strarray[2])
            if strarray[1] == "start":
                if stack1:
                    result[stack1[-1]] += curr - prev
                stack1.append(int(strarray[0]))
                prev = curr
            else:
                result[stack1.pop()] += curr - prev +1
                prev = curr +1
        return result