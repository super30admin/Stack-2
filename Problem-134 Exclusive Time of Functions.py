# 636. Exclusive Time of Functions
# https://leetcode.com/problems/exclusive-time-of-functions/

# Logic: At every start event we push to the stack. 
# When a new start event comes we update the prev 
# id to have the time so far and finally when an 
# end is encountered we update the result.

# Time Complexity: O(n)
# Space Complexity: O(n)

class Solution:
    def exclusiveTime(self, n, logs):
        res = [0 for i in range(n)]
        
        stack = []
        prev = 0
        cur = 0
        
        for i in logs:
            _id, event, idx = i.split(":")
            
            cur = int(idx)
            
            if event == "start":
                if stack:
                    res[stack[-1]] += cur - prev
                
                stack.append(int(_id))
                prev = cur
                
            else:
                res[stack.pop()] += cur - prev + 1
                prev = cur + 1

        return res

obj = Solution()
print(obj.exclusiveTime(2, ["0:start:0","1:start:2","1:end:5","0:end:6"]))