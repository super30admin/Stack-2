# Time Complexity : O(n)
# Space Complexity : O(n) for stack to store function ids
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
# At each start I put the function id in stack and store current and previous time stamp. While starting I look at the top and stack and add the difference
# between current and previous in result. At end I add the curr - prev + 1 to result of stack top

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        result = [0]*n
        stack = []
        prev , curr = 0, 0
        for log in logs:
            log_entry = log.split(":")
            curr = int(log_entry[2])
            
            if log_entry[1] == "start":
                if len(stack) > 0:
                    result[stack[-1]] += curr - prev
                    
                stack.append(int(log_entry[0]))
                prev = curr
            else:
                result[stack[-1]] += curr - prev + 1
                
                stack.pop()
                
                prev = curr + 1
                
        return result
