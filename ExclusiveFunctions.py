#Time complexity: O(n)
#Space complexity: O(n)
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        res=[0]*n
        stack=[]
        prev=0
        for i in logs:
            lst=i.split(":")
            if lst[1]=="start":
                if stack:
                    res[int(stack[-1])]+= int(lst[2])-int(prev)
                stack.append(lst[0])
                prev=lst[2]
            if lst[1]=="end":
                res[int(stack.pop())]+= int(lst[2])-int(prev)+1
                prev=int(lst[2])+1
        return res
                