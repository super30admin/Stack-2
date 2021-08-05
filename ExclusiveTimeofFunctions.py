class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        """using stack
        time complexity-O(number of logs)
        space complexity-O(number of logs)"""
        stack=[]
        arr=[0 for _ in range(n)]
        prev=0
        for i in logs:
            li=i.split(":")
            curr=int(li[2])
            if li[1]=="start":
                if curr!=prev:
                    arr[stack[-1]]+=curr-prev
                stack.append(int(li[0]))
                prev=curr
            elif stack:
                temp=stack.pop()
                if temp==int(li[0]):
                    arr[int(li[0])]+=curr-prev+1
                    prev=curr+1
        return arr
                
                    
                    
        