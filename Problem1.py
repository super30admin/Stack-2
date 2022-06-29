#Time Complexity : O(N)
#Space Complexity : O(N)
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        prev = 0
        curr = 0
        res = [0] * n
        stack = [curr]
        for i in logs:
            strrarr = i.split(':')
            curr = int(strrarr[2])
            if strrarr[1] == "start":
                if stack:
                    res[stack[-1]] += curr - prev 
                stack.append(int(strrarr[0]))
                prev = curr
            else:
                temp = stack.pop()
                res[temp] += curr + 1 - prev
                prev = curr + 1
                
        return res
                
            
        
            