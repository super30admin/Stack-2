class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        
        ## T.C = O(n)
        ## S.C = O(n)

        stack = []
        res = [0]*n
        m = len(logs)

        id, task_type, prev = logs[0].split(':')
        id = int(id)
        prev = int(prev)
        stack.append([id, prev])

        for i in range (1, m):
            id, task_type, time = logs[i].split(':')
            id = int(id)
            time = int(time)
           
            if task_type == "start":
                if stack:
                    res[stack[-1][0]] += time - prev
                prev = time
                stack.append([id, time])
            else:
                prev_id, prev_time = stack.pop()
                if prev_id is not None:
                    res[prev_id] += time - prev + 1
                prev = time + 1
            
        return res
