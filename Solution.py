'''
// Time Complexity :
# Problem 1 - O(m+n) ~ O(n) m - no. of logs, n - no. of intervals
# Problem 2 - O(n)
// Space Complexity :
# Problem 1 - O(n) n - no. of people
# Problem 2 - O(n) 
// Did this code successfully run on Leetcode :
# Yes the code ran successfully.

// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
'''
## Problem 1 - Exclusive Time of Functions
# Initialize a result array of '0's and an empty stack
# Iterate over the logs array and split the logs into interval start time and interval end times
# When the string input is 'start' we check for the empty stack to update the interval in the result
# array and append the stack with this current task
# If the input is 'end' then pop the current task from the stack and update the time in result array
# The tasks are completed and stack is empty we return the result array

class Solution(object):
    def exclusiveTime(self, n, logs):
        """
        :type n: int
        :type logs: List[str]
        :rtype: List[int]
        """
        result = [0 for i in range(n)]
        st = []
        curr = 0; prev = 0
        for log in logs:
            strArr = log.split(':')
            taskId = int(strArr[0])
            curr = int(strArr[2])
            if strArr[1] == 'start':
                if len(st) > 0:
                    result[st[-1]] += (curr - prev)
                st.append(taskId)
                prev = curr
            else:
                poppedTask = st.pop()
                result[poppedTask] += curr - prev + 1
                prev = curr + 1
        return result

## Problem 2 - Valid Parentheses
# Initialize an empty stack
# Iterate over the array of parentheses and check if the opening bracket is followed by a closing 
# bracket.
# To check this whenever we get an opening bracket push the closing bracket in the stack
# When the array gets a closing bracket pop the bracket from the stack
# If stack is empty that means the parentheses is valid and return 'True' else return 'False'

class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        n = len(s)
        st = []
        for i in range(n):
            c = s[i]
            if c == '(':
                st.append(')')
            elif c == '[':
                st.append(']')
            elif c == '{':
                st.append('}')
            elif len(st) < 1 or c != st.pop():
                return False
        if len(st) > 0:
            return False
        return True
