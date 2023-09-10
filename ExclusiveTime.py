#Time Complexity: O(m) m=> length of logs array
#Space Complexity: O(m)
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        stack=[]
        curr=0
        prev=0
        func=0
        #Store results of individual function
        result=[0]*n
        for i in logs:
            split_arr=i.split(":")
            curr=int(split_arr[2])
            func=int(split_arr[0])
            if split_arr[1]=="start":
            #If start add to stack and increment the time of prev function using peek
                if stack:
                    result[stack[-1]]+=curr-prev
                prev=curr
                stack.append(func)
            else:
            #If end, pop function and calculate its time
                pop_index=stack.pop()
                result[pop_index]+=curr+1-prev
                prev=curr+1

        return result