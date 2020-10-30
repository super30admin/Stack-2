/*
 * 636. Exclusive Time of Functions
 * 
 * On a single-threaded CPU, we execute a program containing n functions. Each function has a unique ID between 0 and n-1.

Function calls are stored in a call stack: when a function call starts, its ID is pushed onto the stack, and when a function call ends, its ID is popped off the stack. The function whose ID is at the top of the stack is the current function being executed. Each time a function starts or ends, we write a log with the ID, whether it started or ended, and the timestamp.

You are given a list logs, where logs[i] represents the ith log message formatted as a string "{function_id}:{"start" | "end"}:{timestamp}". For example, "0:start:3" means a function call with function ID 0 started at the beginning of timestamp 3, and "1:end:2" means a function call with function ID 1 ended at the end of timestamp 2. Note that a function can be called multiple times, possibly recursively.

A function's exclusive time is the sum of execution times for all function calls in the program. For example, if a function is called twice, one call executing for 2 time units and another call executing for 1 time unit, the exclusive time is 2 + 1 = 3.

Return the exclusive time of each function in an array, where the value at the ith index represents the exclusive time for the function with ID i.

 

Example 1:
Refer leetcode for image

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
Function 1 starts at the beginning of time 6, executes 1 units of time, and ends at the end of time 6.
Function 0 resumes execution at the beginning of time 6 and executes for 2 units of time.
So function 0 spends 2 + 4 + 1 = 7 units of total time executing, and function 1 spends 1 unit of total time executing.

Example 4:

Input: n = 2, logs = ["0:start:0","0:start:2","0:end:5","1:start:7","1:end:7","0:end:8"]
Output: [8,1]
Example 5:

Input: n = 1, logs = ["0:start:0","0:end:0"]
Output: [1]
 

Constraints:

1. 1 <= n <= 100
2. 1 <= logs.length <= 500
3. 0 <= function_id < n
4. 0 <= timestamp <= 109
5. No two start events will happen at the same timestamp.
6. No two end events will happen at the same timestamp.
7. Each function has an "end" log for each "start" log.

 */

/*
 *	Time Complexity: O (N) -> To traverse the given string array for timestamps and start|end of function ID's
 *
 *  Space Complexity: O (N) -> Stack to store the 'N' fucntion ID's when starts processing 
 *  
 *  Did this code successfully run on leetcode: Yes
 * 
 *  Any problem you faced while coding this: No
 *  
 */

package com.s30.edu.stack2;

import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions {
	public int[] exclusiveTime(int n, List<String> logs) {
        
        //#1. Create an output array
        int[] output = new int[n];
        
        // #2. Create a stack to store function id's currently processing on single threaded CPU 
        Stack<Integer> stack = new Stack<>();
        
        // #3. Initialize prev and currTime 
        int prev = 0; // Inidcates where previous function began
        int currTime = 0; // Indicates where current function is starting
        
        // #4. Traverse thorugh the string of logs saved by each function when started or exited
        for(String log : logs){
            String[] record = log.split(":"); // ["0", "start", "0"], ["1", "start", "2"] etc...
            
            currTime = Integer.parseInt(record[2]); // currTime is the timestamp at which current function(currently processing) began 
            
            // When a function starts its processing at a timestamp
            /*
            *   START:
            *   prev = currTime;
            *   time a previous function ran for = currTime - prev;
            */
            if(record[1].equals("start")){
                if(!stack.isEmpty()){
                    // Compute how long previous function ran for and update the output array at that index(function ID) with units of time it ran for
                    output[stack.peek()] += currTime - prev;
                }
                
                // Convert function ID from string to integer and push to the stack
                stack.push(Integer.parseInt(record[0]));
                
                // Update the prev
                prev = currTime;
                
            }
            // When a function ends its processing at a timestamp
            /*
            *   END:
            *   prev = currTime + 1; // beginning time of a function
            *   time that function(which is ending now) ran for = currTime - prev + 1;
            */
            else{
                // Compute how long a function(which is ending) ran for and update the output array at that index(function ID) with units of time it ran for, pop the function that ended processing
                output[stack.pop()] += currTime - prev + 1;
                prev = currTime + 1;
            }
            
            
        }
        
        return output;
         
    }

}
