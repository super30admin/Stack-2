// Time Complexity : O(m) where m is number of log entries as we iterate through all logs once
// Space Complexity : O(n+m) where n is the number of tasks and m is the maximum depth of the stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : followed discussion in the class


// Your code here along with comments explaining your approach
// We will use stack to keep track of active tasks. For each log entry if it is a "start" we will update the time for the current task and push the new task onto
// the stack. If it is an end then we will pop the task from the stack and update its total time using the difference between the current and previous 
// timestamps. We will maintain prev variable to keep track of the previous timestamp for accurate time calculations.

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        int curr = 0;
        int prev = 0;

        for(String log: logs) {
            String[] strArr = log.split(":");

            int currTask = Integer.parseInt(strArr[0]);
            curr = Integer.parseInt(strArr[2]);

            if(strArr[1].equals("start")) {
                if(!st.isEmpty()) {
                    result[st.peek()] = result[st.peek()] + curr - prev;
                }

                st.push(currTask);
                prev = curr;
            } else {
                result[st.pop()] += curr + 1 - prev;
                prev = curr + 1;
            }
        }

        return result;
    }
}



// Time Complexity : O(n) where n is length of string as each character will be processed at least once
// Space Complexity : O(n) as in worst case stack could hold all opening brackets
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : followed approach discussed in class


// Your code here along with comments explaining your approach
// First we will traverse the string and use a stack to push the corresponsidng closing brackets whenever we are encountering the opening bracket. For each 
// closing bracket we will check if it matches with the top of the stack or not, otherwise string will be invalid. After processing all the characters we will 
// check if the stack is empty or not to check validity of the string.

class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(c == '(') {
                st.push(')');
            } else if (c == '[') {
                st.push(']');
            } else if (c == '{') {
                st.push('}');
            } else {
                if(st.isEmpty() || st.pop() != c) {
                    return false;
                }
            }
        }

        if(!st.isEmpty()) {
            return false;
        }

        return true;

    }
}