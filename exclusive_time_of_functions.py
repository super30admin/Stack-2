'''
636 Exclusive Time of Functions
https://leetcode.com/problems/exclusive-time-of-functions/description/

On a single-threaded CPU, we execute a program containing n functions. Each function has a unique ID between 0 and n-1.

Function calls are stored in a call stack: when a function call starts, its ID is pushed onto the stack, and when a function call ends, its ID is popped off the stack. The function whose ID is at the top of the stack is the current function being executed. Each time a function starts or ends, we write a log with the ID, whether it started or ended, and the timestamp.

You are given a list logs, where logs[i] represents the ith log message formatted as a string "{function_id}:{"start" | "end"}:{timestamp}". For example, "0:start:3" means a function call with function ID 0 started at the beginning of timestamp 3, and "1:end:2" means a function call with function ID 1 ended at the end of timestamp 2. Note that a function can be called multiple times, possibly recursively.

A function's exclusive time is the sum of execution times for all function calls in the program. For example, if a function is called twice, one call executing for 2 time units and another call executing for 1 time unit, the exclusive time is 2 + 1 = 3.

Return the exclusive time of each function in an array, where the value at the ith index represents the exclusive time for the function with ID i.

Example 1:
Input: n = 2, logs = ["0:start:0","1:start:2","1:end:5","0:end:6"]
Output: [3,4]
Explanation:
Function 0 starts at the beginning of time 0, then it executes 2 for units of time and reaches the end of time 1.
Function 1 starts at the beginning of time 2, executes for 4 units of time, and ends at the end of time 5.
Function 0 resumes execution at the beginning of time 6 and executes for 1 unit of time.
So function 0 spends 2 + 1 = 3 units of total time executing, and function 1 spends 4 units of total time executing.

Example 2:
Input: n = 1, logs = ["0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"]
Output: [8]
Explanation:
Function 0 starts at the beginning of time 0, executes for 2 units of time, and recursively calls itself.
Function 0 (recursive call) starts at the beginning of time 2 and executes for 4 units of time.
Function 0 (initial call) resumes execution then immediately calls itself again.
Function 0 (2nd recursive call) starts at the beginning of time 6 and executes for 1 unit of time.
Function 0 (initial call) resumes execution at the beginning of time 7 and executes for 1 unit of time.
So function 0 spends 2 + 4 + 1 + 1 = 8 units of total time executing.

Example 3:
Input: n = 2, logs = ["0:start:0","0:start:2","0:end:5","1:start:6","1:end:6","0:end:7"]
Output: [7,1]
Explanation:
Function 0 starts at the beginning of time 0, executes for 2 units of time, and recursively calls itself.
Function 0 (recursive call) starts at the beginning of time 2 and executes for 4 units of time.
Function 0 (initial call) resumes execution then immediately calls function 1.
Function 1 starts at the beginning of time 6, executes 1 unit of time, and ends at the end of time 6.
Function 0 resumes execution at the beginning of time 6 and executes for 2 units of time.
So function 0 spends 2 + 4 + 1 = 7 units of total time executing, and function 1 spends 1 unit of total time executing.

Constraints:
1 <= n <= 100
2 <= logs.length <= 500
0 <= function_id < n
0 <= timestamp <= 10^9
No two start events will happen at the same timestamp.
No two end events will happen at the same timestamp.
Each function has an "end" log for each "start" log.

Solution:
1. Stack
Use a stack to track which function is running at any given time. If a function starts, we pause the previous one and calculate how much it ran. When a function ends, we pop it and add its exclusive duration, adjusting for time units.

More detailed explanation:
• Parse logs sequentially: A helper function breaks down each log string into its numerical ID, operation type ("start" or "end"), and timestamp.

• Tracks time deltas: It maintains two pointers, prev and curr, to track the timestamps of the previous and current logs, allowing it to calculate elapsed time slices.

• Handles "start" operations: When we encounter a "start" operation, we calculate the execution time for the function currently at the top of the stack (curr - prev), add it to that function's total, and push the new function ID onto the stack.

• Handles "end" operations: When we encounter an "end" operation, we pop that function ID from the stack, compute its final exclusive time block including the end timestamp (curr + 1 - prev), update its total, and advance the prev timeline pointer.

Time: O(M), Space: O(M), M = length of the list 'logs'

https://youtu.be/3zqVinluGSM?t=319 (YT video - good illustration of the problem)
https://youtu.be/sK5YcQAed5k?t=1756 (RK - 2 small examples)
https://youtu.be/jQco2C4_DdY?t=468 (7:48 - 21:20: JS - 1 big example)

'''

from typing import List

def exclusiveTime(n: int, logs: List[str]) -> List[int]:
    ''' Time: O(M), Space: O(M)
        M = length of the list 'logs'
    '''
    def split_log(log):
        str_arr = log.split(':')
        func_id, op, t = str_arr
        func_id = int(func_id)
        t = int(t)
        return func_id, op, t

    if n == 0:
        return []
    result = [0]*n
    stack = []
    peek = -1

    # push the first element of logs to the stack
    prev_func_id, op, t = split_log(logs[0])
    stack.append(prev_func_id)
    prev, curr = 0, 0 # timestamps of the previous and current logs

    # push the remaining elements of logs to the stack
    for log in logs[1:]:
        # parse the log
        curr_func_id, op, curr = split_log(log)

        # get the func id of the previous log
        if not stack: # no pending jobs
            prev_func_id = curr_func_id
            prev = curr
        else: # at least 1 job is still pending
            prev_func_id = stack[peek]

        # process the log differently based on
        # whether it is a start or end
        if op == "start": # push curr func id if a job starts
            stack.append(curr_func_id)
            delta = curr - prev
            result[prev_func_id] += delta
            prev = curr
        elif op == "end": # pop func id if a job ends
            prev_func_id = stack.pop() # pop func id if a job ends
            assert prev_func_id == curr_func_id, f"pop func id = {prev_func_id}, curr func id = {curr_func_id} do not match"
            delta = (curr + 1) - prev
            result[prev_func_id] += delta
            prev = curr + 1
    return result


def run_tests():
    tests = [(["0:start:0","1:start:2","1:end:5","0:end:6"], 2, [3,4]),
             (["0:start:0","0:end:1","1:start:5","1:end:6"], 2, [2,2]),
             (["0:start:0","0:end:1","1:start:5","1:end:6"], 2, [2,2]),
             (["0:start:0","0:start:2","0:end:5","1:start:6","1:end:6","0:end:7"], 2, [7,1]),
             (["0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"], 1, [8]),
             (["0:start:0","0:end:0","1:start:1","1:end:1","2:start:2","2:end:2","2:start:3","2:end:3"], 3, [1,1,2]),
             (["0:start:0","1:start:2","2:start:4","2:end:6","1:end:8", "0:end:11"], 3, [5,4,3]),
    ]
    for test in tests:
        logs, n, ans = test[0], test[1], test[2]
        result = exclusiveTime(n, logs)
        print(f"\nLogs = {logs}")
        print(f"No. of jobs = {n}")
        print(f"Job execution times = {result}")
        passed = (ans == result)
        assert passed == True, f"Test case failed"
        print(f"Pass: {passed}")
    print(f"\nDONE")

run_tests()