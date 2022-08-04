# Time Complexity : O(n)
# Space Complexity : O(n);
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
class Solution:
    def exclusiveTime(self, n: int, logs: list[str]) -> list[int]:
        prev = int(logs[0][-1])
        stack = []
        result = [0]*n
        for i in logs:
            lst = i.split(':')
            Id = int(lst[0])
            index = int(lst[-1])
            if lst[1] == 'start':
                if stack:
                    result[stack[-1]] += (index-prev)
                stack.append(Id)
                prev = index
            elif lst[1] == 'end':
                pop = stack.pop()
                result[pop] += (index-prev+1)
                prev = index+1
        return result


print(Solution().exclusiveTime(2, ["0:start:0","0:start:2","0:end:5","1:start:6","1:end:6","0:end:7"]))
