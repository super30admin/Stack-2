import java.util.Stack;

//Time complexity : O(n)
//Space Complexity :   O(n) in worst case if there are no pairs
//Did it run on leetcode : yes

public class ValidParenthesis {

    public boolean isValid(String s) {
        if(s == null || s.length() == 0) return true;

        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(') st.push(')');
            else if(c == '[') st.push(']');
            else if(c == '{') st.push('}');
            else if(st.isEmpty() || st.pop() != c) return false;
        }
        if(!st.isEmpty()) return false;
        return true;
    }

}
