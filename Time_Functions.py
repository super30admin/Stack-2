# Time complexity : O(n) --> n - length of logs
# Space complexity : O(n) --> n - length of logs
# Leetcode : Solved and submitted

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
      # declare a res array with all 0's
        res = [0]*n
        if not logs:
            return [0]
          
        # setting th curr, prev and empty stack
        curr = prev = 0
        st = []
        
        # traversing each log
        for log in logs:
          # split the log into each data
            data = log.split(':')
            task = int(data[0])
            curr = int(data[2])
            
            # when we have a start log
            if data[1] == 'start':
              # update the res for task on top of the stack
                if st:
                    res[st[-1]] += curr - prev
                # append the new task and update the prev
                st.append(task)
                prev = curr
                
            else:
              # pop the top of the curr and update it in the res
                res[st.pop()] += curr +1 - prev
                # update the prev to effective curr + 1
                prev = curr + 1
        
        return res
