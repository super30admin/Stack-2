# Time complexity:O(n)
# Space complexity: 0(n)
# Did code run successfully on leetcode: yes
# Any problem you faced: No



class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0) return true;

        Stack<Character> stack = new Stack<>();


        for(int i = 0; i < s.length(); i++){

        char ch = s.charAt(i);


        if(ch == '(') stack.push(')');
        if(ch == '{') stack.push('}');
        if(ch == '[') stack.push(']');

        if(ch == ')' || ch == '}'|| ch == ']' ){
             if(stack.isEmpty()) return false;

            if(ch!=stack.pop()) return false;

        }


        }

        return stack.isEmpty();
    }

}