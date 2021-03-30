
/**
Time Complexity : O(N)
Space Complexity : O(N)
is Worked on Leetcode : YES
iterate over string and push the char to stack if you don;t match, if match then popped out
// at last check if stack is empty or not
// if stack is empty then it is valid else not.


Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
Example 4:

Input: s = "([)]"
Output: false
Example 5:

Input: s = "{[]}"
Output: true
 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.


**/
class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> st = new Stack();
        
        for(int i =0;i< s.length();i++) {
            Character ch = s.charAt(i);
            
            if(st.isEmpty()) {
                st.push(ch);
                
            }else{
                
                Character top  = st.peek();
                // balance
                if( (top == '[' && ch == ']')  ||
                   (top == '(' && ch == ')')  ||
                   (top == '{' && ch == '}') 
                   
                  ) {
                    st.pop();
                }else{
                    st.push(ch);
                }
                
            }
            
            
        }
        
        return st.isEmpty();
    }
}


