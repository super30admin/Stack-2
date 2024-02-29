#Time Complexity : O(n)
#Space Complexity : O(n)
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :No

from ast import List


class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        exclusive_time = [0] * n
        stack = []
        prev_time = 0

        for log in logs:
            id_num, action, timestamp = log.split(':')
            id_num, timestamp = int(id_num), int(timestamp)

            if action == "start":
                if stack:
                    exclusive_time[stack[-1]] += timestamp - prev_time
                stack.append(id_num)
                prev_time = timestamp
            
            else:
                exclusive_time[stack.pop()] += timestamp - prev_time + 1
                prev_time = timestamp + 1
        
        return exclusive_time