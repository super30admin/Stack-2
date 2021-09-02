#space:O(n)
#time:O(n)
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        if n == 0 or logs is None:
            return []
        list_val = [0]*n
        stack = []
        curr=prev=0
        for text in logs:
            text_list = text.split(":")
            task,process,curr = int(text_list[0]),text_list[1],int(text_list[2])
            if process == "start":
                if stack:
                    list_val[stack[-1]]+=curr-prev
                stack.append(task)
            
            else:
                list_val[stack.pop()]+=curr-prev+1
                curr+=1
            prev=curr
        return list_val
                