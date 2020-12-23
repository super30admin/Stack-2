
# Time - O(n)
# Space- O(n) - apart from auxilary DS ie., the res array(O(n)), stack is making O(n) space
# des - add values into the stack if the curr process is on start and add the units based on previous process start else if its end then pop the process and calucate the difference btw start and stop +1 will be the num od units


class Solution:
    from collections import defaultdict
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        stack=[]
        res=[0]*n
        prev=0
        for i in range(len(logs)):
            arr=logs[i].split(':')
            curr=int(arr[2])
            if arr[1]=='start':
                if stack:
                    res[stack[len(stack)-1]]+=curr-prev
                    prev=curr
                stack.append(int(arr[0]))
            else:
                res[stack.pop()]+=curr-prev+1
                prev=curr+1
        return res