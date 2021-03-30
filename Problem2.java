// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch=='(' || ch=='{' || ch=='['){//add all parenthesis
                st.push(ch);
            }
            else if(!st.isEmpty()){//pop only the corrrect combination
                char check= st.peek();
                if(ch==')' && check=='(') st.pop();
                else if(ch==']' && check=='[') st.pop();
                else if(ch=='}' && check=='{') st.pop();
                else return false;
            }
            else return false;
            
        }
        return st.isEmpty();
    }
}