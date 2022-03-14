# sc and tc : O(n)
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        
        stack = []
        res = [0]*(n)
        
        for ele in logs:
            id, sten, time = ele.split(":")
            id = int(id)
            time = int(time)
            
            if sten == "end":
                peek = stack[-1]
                res[id] += abs(peek[2] - time) 
                res[id] += 1
                stack.pop()
                if stack:
                    stack[-1][2] = time + 1
        
            elif sten == "start":
                if stack:
                    res[stack[-1][0]] += abs(stack[-1][2] - time) 
                    stack.append([id, sten, time])
                else:
                    stack.append([id, sten, time])
                
            #print(stack)
            
        return res
            
