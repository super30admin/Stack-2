// Time Complexity :O(n) where n is the length of the string s
// Space Complexity :O(n) for the stack space, as the hashMap will be of constant size
// Did this code successfully run on Leetcode :yes
import java.util.HashMap;
import java.util.Stack;
public class ValidParentheses {
    private HashMap<Character, Character> map;

    public boolean isValid(String s) {
        int len = s.length();
        if(len %2 != 0){
            return false;
        }
        this.map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> st = new Stack<>();
        for(int i =0; i<len; i++){
            Character c = s.charAt(i);
            if(map.containsKey(c)){
                //closing chars
                if(st.isEmpty() || map.get(c) != st.peek()){
                    return false;
                }
                st.pop();
            }else{
                st.push(c);
            }
        }
        return st.isEmpty();
    }
}
