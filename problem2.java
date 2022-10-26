//Problem2 - https://leetcode.com/problems/valid-parentheses/

// Time Complexity : O(n)
// Space Complexity : O(n) //Constant
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this: No 

public class problem2 {
    public boolean isValid(String s) {
        Stack<Character> set = new Stack<>();
        char[] ch = s.toCharArray();

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '(' || ch[i] == '[' || ch[i] == '{') {
                set.push(ch[i]);
            } else {
                if (ch[i] == ')') {
                    if (set.isEmpty() || set.pop() != '(')
                        return false;
                }
                if (ch[i] == ']') {
                    if (set.isEmpty() || set.pop() != '[')
                        return false;
                }
                if (ch[i] == '}') {
                    if (set.isEmpty() || set.pop() != '{')
                        return false;
                }
            }
        }
        return set.isEmpty();
    }
}
