# Stack-2

## Problem1 Exclusive Time of Functions (https://leetcode.com/problems/exclusive-time-of-functions/)

# Initialize a result array of '0's and an empty stack
# Iterate over the logs array and split the logs into interval start time and interval end times
# When the string input is 'start' we check for the empty stack to update the interval in the result
# array and append the stack with this current task
# If the input is 'end' then pop the current task from the stack and update the time in result array
# The tasks are completed and stack is empty we return the result array

## Problem2 Valid Parentheses (https://leetcode.com/problems/valid-parentheses/)

# Initialize an empty stack
# Iterate over the array of parentheses and check if the opening bracket is followed by a closing 
# bracket.
# To check this whenever we get an opening bracket push the closing bracket in the stack
# When the array gets a closing bracket pop the bracket from the stack
# If stack is empty that means the parentheses is valid and return 'True' else return 'False'