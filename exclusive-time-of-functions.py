# tc O(n), sc O(n).
stack, res = [], [0] * n
for log in logs:
    id, func, curr_time = log.split(":")
    id, curr_time = int(id), int(curr_time)
    if func == "start":
        stack.append((id, curr_time))
    elif func == "end" and id == stack[-1][0]:
        pop_id, insert_time = stack.pop()
        time_taken = curr_time - insert_time + 1
        res[pop_id] += time_taken

        if stack:
            res[stack[-1][0]] -= time_taken # time taken by this process is the overlap time for prev process in stack
return res