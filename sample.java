## Problem1 Exclusive Time of Functions (https://leetcode.com/problems/exclusive-time-of-functions/)

// Time Complexity : 0(n) where n is the number of logs or log size
// Space Complexity : 0(n) where n is the number of functions. This is because the result array and the stack will store information for each function
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if (logs == null || logs.size() == 0 || n == 0) {
            return new int[]{};
        }
        int[] result = new int[n];
        Stack<Integer> s = new Stack<>();
        int prev = 0;
        int curr = 0;

        for (int i = 0; i < logs.size(); i++) {
            String log = logs.get(i);
            String[] splitlog = log.split(":");
            curr = Integer.parseInt(splitlog[2]);
            if (splitlog[1].equals("start")) {
                if(!s.isEmpty()) {
                    result[s.peek()] += curr - prev;
                }
                prev = curr;
                s.push(Integer.parseInt(splitlog[0]));
            }
            else {
                int polled = s.pop();
                result[polled] += curr - prev + 1;
                prev = curr + 1;
            }
        }
        return result;
    }
}


## Problem2 Valid Parentheses (https://leetcode.com/problems/valid-parentheses/)

// Time Complexity : 0(n) where n is the length of the input string s. This is because the function iterates through each character in the string once
// Space Complexity : 0(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

# Solution 1

class Solution {
    public boolean isValid(String s) {
        Stack<Character> charatcters = new Stack<>(); // store opening brackets
        // iterates through each character in the input string s
        for(char ch : s.toCharArray()) {       
            // character is an opening bracket pushed into the stack.       
            if (ch == '(' || ch == '{' || ch == '['){
                charatcters.push(ch);
            } 
            // character is a closing bracket check if the stack is empty or if the top of the stack does not match the closing bracket
            // closing bracket matches the top of the stack then pop
            else if(ch == ')' && !charatcters.isEmpty() && charatcters.peek() == '('){
                charatcters.pop();
            } else if(ch == '}' && !charatcters.isEmpty() && charatcters.peek() == '{'){
                charatcters.pop();
            } else if(ch == ']' && !charatcters.isEmpty() && charatcters.peek() == '['){
                charatcters.pop();
            } else {
                return false;
            }
        }
        return charatcters.isEmpty();   // return true
    }
}

# Solution 2

// Time Complexity : 0(n) 
// Space Complexity : 0(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(')');
            }
            else if (c == '{') {
                stack.push('}');
            }
            else if (c == '[') {
                stack.push(']');
            }
            else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty(); 
    }
}