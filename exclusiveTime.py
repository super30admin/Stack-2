# TIme Complexity: O(n)
# Space Complexity: O(n)
# Approach: Create a result array of size n and a stack.
#			For each entry in log, see if the log type is start or not.
#			If start push the entry into the stack
#			Else the status can be either be end or done ( a new state introduced by me)
#				While the stack top status is done keep popping and adding it to an offset. 
#				The done status represents the time taken by the nested functions inside the caller function.
#				This total offset time will be minused from the start end difference of the caller function.
#				Once the status is start, find the caller time will be "end - start - offset + 1".
#				Update the result array and push a new done state in the stack with time value as start - end + 1

class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        result = [0] * n
        stack = []
        for i in logs:
            split_val = i.split(":")
            
            if split_val[1] == "start":
                stack.append(split_val)
            else:
                offset = 0
                while stack[-1][1] == "done":
                    pop_val = stack.pop()
                    offset += pop_val[2]

                if split_val[1] == "end" and len(stack) > 0 and stack[-1][1] == "start" and stack[-1][0] == split_val[0]:
                    pop_val = stack.pop()
                    
                    time = int(split_val[2]) - int(pop_val[2])
                    final_time = time - offset
                    result[int(split_val[0])] += final_time + 1

                    stack.append([split_val[0],"done", time + 1])
                    
        return result
                    