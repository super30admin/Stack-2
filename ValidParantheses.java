// Time Complexity :  O(n)
// The algorithm iterates through the input string once, where 'n' is the length of the input string. For each character, the operations involving the stack (push and pop) are constant time operations. Hence, the overall time complexity is linear, O(n).
// Space Complexity : O(n)
// In the worst case, all characters in the input string are opening parentheses, and thus, the stack could potentially store all of them. Therefore, the space complexity is proportional to the length of the input string, O(n).
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

import java.util.Stack;

public class ValidParantheses {
    public boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();

        // Traverse through the string
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            // If the current character is an opening bracket, push it onto the stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            // If the current character is a closing bracket
            else if (c == ')' || c == '}' || c == ']') {
                // If the stack is empty, then the parentheses are not balanced
                if (stack.isEmpty()) {
                    return false;
                }
                // Pop the top element from the stack and check if it is a matching opening
                // bracket
                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        // If the stack is not empty, then the parentheses are not balanced
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParantheses validator = new ValidParantheses();

        String str1 = "(({}))";
        System.out.println(str1 + " is valid: " + validator.isValid(str1));

        String str2 = "{[()]}";
        System.out.println(str2 + " is valid: " + validator.isValid(str2));

        String str3 = "({[})";
        System.out.println(str3 + " is valid: " + validator.isValid(str3));

        String str4 = "{[()]}{}";
        System.out.println(str4 + " is valid: " + validator.isValid(str4));
    }
}
