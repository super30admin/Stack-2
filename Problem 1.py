class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:

        "0:start:0",
        "1:start:2",
        "1:end:5",
        "0:end:6"

        s = []
        res = [0]*(n)

        for log in logs:
            task, act, time = log.split(":")
            task, time = int(task), int(time)

            if act == "start":
                if s:
                    res[s[-1][0]] += time - s[-1][1]
                
                s.append([task, time])
               
            else: #if ending some task
                prev_task, prev_time = s.pop()
                
                res[prev_task] += (time - prev_time + 1)

                if s:
                    s[-1][1] = time + 1
               
        return res
