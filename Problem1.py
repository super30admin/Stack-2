# Time Complexity : O(n) 
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

class Solution:
    def exclusiveTime(self, n, logs):
        result = [0 for _ in range(n)]
        if logs is None or len(logs) == 0:
            return result
        prev, curr = 0 , 0
        stack = []
        for i in range(len(logs)):
            array = logs[i].split(':')
            curr = int(array[2])
            
            if array[1] == 'start':
                if stack:
                    result[stack[-1]] += curr - prev 
                stack.append(int(array[0]))
                prev = curr
            else:
                top = stack.pop()
                result[top] += curr - prev + 1 
                prev = curr + 1 
        return result 

if __name__ == "__main__":
    s = Solution()
    n = 2
    logs = ["0:start:0","1:start:2","1:end:5","0:end:6"]

    # Test case 1 
    print(s.exclusiveTime(n ,logs))