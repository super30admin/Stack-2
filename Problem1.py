
'''
Problem: Exclusive Time of Functions
Time Complexity: O(n), where n is given elements
Space Complexity: O(n) for stack
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
        maintained curr and prev timestamp
        if start log then add curr-prev to result and append to stack
        if end, then add curr+1 - prev and pop stack
'''

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        curr = 0
        prev = 0
        result = [0]*n
        stack = []

        for log in logs:
            idx, action, time = log.split(':')
            idx = int(idx)
            time = int(time)
            curr = time
            if action == 'start':
                if stack:
                    result[stack[-1]]+=curr - prev
                stack.append(idx)
                prev = curr
                
            else:
                curr = time + 1
                if stack and stack[-1] == idx:
                    result[idx] += curr - prev
                    stack.pop()
                prev = curr
        
        return result