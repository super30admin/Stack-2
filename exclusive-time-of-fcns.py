# O(n) time, O(n) space
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        formattedLogs = []
        for log in logs:
            i,status,timestamp = log.split(':')
            formattedLogs.append((int(i),status,int(timestamp)))
        print(formattedLogs)
        # [(0, 'start', 0), (0, 'start', 2), (0, 'end', 5), (0, 'start', 6), (0, 'end', 6), (0, 'end', 7)]
        #                                         p
        # stack = [[0,0],[0,2]]
        # ans = [2]
        ans = [0]*n
        stack=[]
        for (i,status,timestamp) in formattedLogs:
            
            if status == 'start':
                if stack:
                    ans[stack[-1][0]] += timestamp - stack[-1][1]
                stack.append([i,timestamp])
            else:
                ans[i]+=timestamp-stack.pop()[1]+1
                if stack:
                    stack[-1][1]=timestamp+1
        return ans 