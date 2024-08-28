# Stack-2

## Problem1 Exclusive Time of Functions (https://leetcode.com/problems/exclusive-time-of-functions/)

We will use stack to keep track of active tasks. For each log entry if it is a "start" we will update the time for the current task and push the new task onto the stack. If it is an end then we will pop the task from the stack and update its total time using the difference between the current and previous timestamps. We will maintain prev variable to keep track of the previous timestamp for accurate time calculations.



## Problem2 Valid Parentheses (https://leetcode.com/problems/valid-parentheses/)

First we will traverse the string and use a stack to push the corresponsidng closing brackets whenever we are encountering the opening bracket. For each closing bracket we will check if it matches with the top of the stack or not, otherwise string will be invalid. After processing all the characters we will check if the stack is empty or not to check validity of the string.