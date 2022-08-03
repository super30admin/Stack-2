# Time Complexity: O(N) N=length of logs
# Space Complexity: O(n)
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        prev=0
        result=[0]*n
        stack=[]
        for log in logs:
            arr=log.split(':')
            cur=int(arr[2])
            if arr[1]=='start':
                if len(stack)!=0:
                    result[stack[-1]]+=cur-prev
                prev=cur
                stack.append(int(arr[0]))
            else:
                result[stack.pop()]+=cur+1-prev
                prev=cur+1
        return result        