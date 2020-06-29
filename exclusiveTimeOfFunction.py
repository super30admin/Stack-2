# Time Complexity - O(N)
# Space Complexity - O(N)
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        stack=[]
        prev, curr = 0, 0
        result=[0]*n
        for log in logs:
            element = log.split(":")
            curr = int(element[2])
            if(element[1] == "start"):
                #what happens when we see a start
                if(stack):
                    #what happens if stack has elements
                    result[stack[-1]]+=curr-prev
                    prev=curr
                stack.append(int(element[0]))       
            else:
                result[stack.pop()]+=curr-prev+1
                prev=curr+1
        return result
