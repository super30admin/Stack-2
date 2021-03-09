'''
# Time complexity - O(N) : N is no.of entries in log
# Space Complexity: O(N) : 
# Did this code successfully run on LeetCode?: Yes
# Problems faced while coding this:None
# Approach : for start : push index into the stack and calculate the unites ran by the prev process by peeking into the stack
for end : pop from stack and calculate the unit for thr process.
'''
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        if logs is None or len(logs) == 0:
            return []
        
        result = [0]*n
        stack = []
        curr = 0
        prev = 0
        for i in range(len(logs)):
            string = logs[i].split(":")
            curr = int(string[2])
            if string[1] == "start":
                if len(stack) > 0:
                    result[stack[-1]] += curr - prev
                    prev = curr
                stack.append(int(string[0]))
                
            else:
                result[stack.pop()] += curr - prev + 1
                prev = curr + 1
                
        return result