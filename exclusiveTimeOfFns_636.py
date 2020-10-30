# // Time Complexity : O(N)
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

# // Your code here along with comments explaining your approach
# Since they are using a stack, we know that task 0 can't finish before 1. Why stack? 1. maintaining the order is required(which came first and what came after) and 2. given in the question
# Can we put tuple in the stack? (function Id, index)
# Traverse through the logs one and check if it is "start": check is stack is empty: if stack is not empty then add result[stack.peek()] += currTime - prev;
# If at "end", push first element to the stack and prev time=currTime
# Otherwise, else, it is now "end",  result[stack.pop()] += currTime - prev + 1; and prevtime =currTime + 1 and return result

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        output = [0]*n
        
        stack = []
        currTime, prev = 0,0
        
        for log in logs:
            
            record=log.split(":");
            currTime = int(record[2])
            
            if record[1]=="start":
                if stack:
                    output[stack[-1]] += currTime - prev
                stack.append(int(record[0]))
                prev = currTime
            else:
                output[stack.pop()] += currTime - prev+1
                prev = currTime+1
            
        return output
        