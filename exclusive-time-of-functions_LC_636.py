#TC:O(N) SC:O(N)
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        result=[0]*n
        stack=[]
        curr=0
        prev=0
        for i in logs:
            arr = i.split(":")
            index=int(arr[0])
            curr=int(arr[2])
            if arr[1]=="start":
                if stack!=[]:
                    result[stack[-1]] += curr-prev
                stack.append(index)     
                prev=curr
            else: 
                result[stack[-1]] += curr-prev+1
                stack.pop()
                prev=curr+1
        return result
                

            
        
