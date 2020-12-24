// Time Complexity :  O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

//Make a hashmap with closing brackets as key to check whenever a closing bracket appears that
//corresponding opening bracket lies on the top of stack or not. 
//if not return false;
//if true, then pop and continue the loop until the length of the string 
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        for(char c : s.toCharArray()){
            if(map.containsKey(c)){
                if(!st.isEmpty() && map.get(c) == st.peek()){
                        st.pop();
                }else{
                    return false;      
                }
            }
            else{
                st.push(c);
            }     
        }
        return st.isEmpty();
    }
}
