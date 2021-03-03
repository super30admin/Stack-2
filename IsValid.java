// Time Complexity : The time complexity is O(n) where n is the length of the string
// Space Complexity : The space complexity is O(n) where n is the length of the string
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public boolean isValid(String s) {

        if(s.length() == 1){
            return false;
        }

        Stack<Character> st = new Stack<>();

        for(int i=0;i<s.length();i++){

            char ch = s.charAt(i);

            // Opening brackets
            if(ch == '(' || ch == '[' || ch == '{'){
                st.push(ch);
            }
            // closing brackets
            else{
                if(st.isEmpty()){
                    return false;
                }
                // check if the brackets match
                else if(ch == ')'){
                    if(st.peek() == '('){
                        st.pop();
                    }
                    else{
                        return false;
                    }
                }
                else if(ch == ']'){
                    if(st.peek() == '['){
                        st.pop();
                    }
                    else{
                        return false;
                    }
                }
                else{
                    if(st.peek() == '{'){
                        st.pop();
                    }
                    else{
                        return false;
                    }
                }
            }
        }

        if(!st.isEmpty()){
            return false;
        }
        return true;

    }
}
