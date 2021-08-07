class Solution(object):
    def exclusiveTime(self, n, logs):
        """
        :type n: int
        :type logs: List[str]
        :rtype: List[int]
        """
        # time complexity: O(n)
        # space complexity: O(n)
        result  = [0 for x in xrange(n)]
        task_stack = []
        prev = 0
        
        for log in logs:
            log_li = log.split(':')
            log_id = int(log_li[0])
            log_act = log_li[1]
            log_time = int(log_li[2])
            curr = log_time
            if log_act == 'start':
                if task_stack:
                    result[task_stack[-1]] += curr - prev
                    prev = curr
                task_stack.append(log_id)
            else:
                idx = task_stack.pop()
                result[idx] += curr - prev + 1
                prev = curr + 1
        return result
                    
        
