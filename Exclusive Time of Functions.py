class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        #Time: O(N)
        #Space: O(N)
        sol = [0]*n
        stack = []
        curr_time = 0
        prev = 0
        for log in logs:
            curr=log.split(":");
            if curr[1]=='start':
                if len(stack)!=0:
                    sol[stack[-1]]+=int(curr[2])-prev
                stack.append(int(curr[0]))
                prev=int(curr[2])
            else:
                sol[stack.pop()]+=int(curr[2])-prev+1
                prev=int(curr[2])+1
        return sol
                
                
                
        