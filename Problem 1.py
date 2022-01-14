# Time: O(n)
# Space: O(n)
class Solution(object):
    def exclusiveTime(self, n, logs):
        """
        :type n: int
        :type logs: List[str]
        :rtype: List[int]
        """
        stack = []
        curr = 0
        prev = 0 
        result = [0]*n
        for log in logs:
            vals = log.split(':')
            curr = int(vals[2])
            if vals[1] == 'start':
                if len(stack) != 0:
                    result[stack[-1]] += (curr - prev)
                prev = curr
                stack.append(int(vals[0]))
            else:
                result[stack.pop()] += (curr-prev+1)
                prev = curr + 1
        return result
            
        
