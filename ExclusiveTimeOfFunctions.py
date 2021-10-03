"""
Time Complexity : O(n) where n is the no. of logs
Space Complexity : O(n) where n is the no. of logs
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        if n == 0:
            return []
        result = [0]*n
        stack = []
        prev = 0
        # We traverse through the logs and split the strign in three. Whenever we 
        # encounter "start" we get the top element on stack which gives the process id
        # and thus we can set it's value in result as the diff between curr and prev
        # process times. After that we update the prev pointer and append the curr time         # to the stack. If we found "end" we remove the top element and that process id
        # would be updated to the diff of curr and prev timestamp values plus one. 
        # After we update the prev pointer to the curr plus 1
        for log in logs:
            string = log.split(":")
            curr = int(string[2])
            if string[1] == "start":
                if stack:
                    result[stack[-1]] += curr - prev
                    prev = curr
                stack.append(int(string[0]))
            else:
                result[stack.pop()] += curr + 1 - prev
                prev = curr + 1
        return result