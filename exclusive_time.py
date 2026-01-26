class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        result = [0 for i in range(n)]
        call_stack = []
        call_stack.append(int(logs[0].split(":")[0]))
        prev = int(logs[0].split(":")[-1])
        i = 1

        while i < len(logs):
            id, state, time = logs[i].split(":")
            id, time = int(id), int(time)

            if state == "start":
                if call_stack: 
                    result[call_stack[-1]] += time - prev
                call_stack.append(id)
                prev = time

            else:
                # unlike in state = start where we check for the size of stack we dont need to do that here
                # since if state is "end" then it indicates that there must be some function already executing i.e pushed in the call stack at some point in time
                result[call_stack[-1]] += time - prev + 1
                call_stack.pop()
                prev = time + 1
            
            i += 1
        
        return result


        