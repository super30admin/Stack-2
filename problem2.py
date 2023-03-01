#time O(N)
#space O(N)
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:

        result = [0]*n
        stack = []
        
        for i, log in enumerate(logs):
            curr_fid, curr_event, curr_time = log.split(":")
            if curr_event == "start":
                stack.append(log)
            elif curr_event == "end":
                prev_fid, prev_event, prev_time = stack.pop().split(":")
                result[int(curr_fid)] += int(curr_time)-int(prev_time)+1
                if stack:
                    prev_fid1, prev_event1, prev_time1 = stack[-1].split(":")
                    result[int(prev_fid1)] -= (int(curr_time)-int(prev_time))+1
        
        return result