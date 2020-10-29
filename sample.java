// Problem 1 - Exclusive Time of Functions
// Time Complexity : O(n) where n = length of logs
// Space Complexity : O(n)

// Your code here along with comments explaining your approach
// 1 - iterate throght the logs
// 2 - split the string at colon
// 3 - if  function starts,
// 4 - check if stack is not empty
// 5 - then last func in stack result is curr - prev + result
// 6 - push the function to stack
// 7 - change prev to curr
// 8 - if function ends,
// 9 - result of stack peek's function is result + curr - prev + 1
// 10 - prev is change to curr + 1
// 11 - pop from stack
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if (logs == null || logs.size() == 0) {
            return new int[]{};
        }
        
        int prev = 0;
        int curr = 0;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        // 1  
        for (String log : logs) {
            // 2
            String[] logArray = log.split(":");
            String exec = logArray[1];
            int func = Integer.parseInt(logArray[0]);
            curr = Integer.parseInt(logArray[2]);
            // 3
            if (exec.startsWith("start")) {
                if (!stack.isEmpty()) { // 4
                    result[stack.peek()] += (curr - prev); // 5
                }
                
                stack.push(func); // 6
                prev = curr; // 7
            } else { // 8
                result[stack.peek()] += (curr - prev + 1); // 9
                prev = curr + 1; // 10
                stack.pop(); // 11
            }
        }
        
        return result;
    }
}

// Problem 2 - Valid Parentheses
// Time Complexity : O(n) where n = length of string
// Space Complexity : O(n), extra space for stack

// Your code here along with comments explaining your approach
// 1 - loop over string
// 2 - if opening bracket, push respective closing bracket to stack
// 3 - else if stack is empty or peek bracket not equal to current bracket, return false
// 4 - else if peek bracket equals current bracket, just pop from stack
// 5 - end return stack is empty
class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        Stack<Character> stack = new Stack<>();
        // 1
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            // 2
            if (ch == '(') {
                stack.push(')');
            } else if (ch == '[') {
                stack.push(']');
            } else if (ch == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.peek() != ch) { // 3
                return false;
            } else if (stack.peek() == ch) { // 4
                stack.pop();
            }
        }
        // 5
        return stack.isEmpty();
    }
}
