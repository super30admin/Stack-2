// Time : O(n)
//Space: O(n)
//LeetCode: Yes
//
//Approach
// 1. have a map with key as closing brackets and values as its corresponding opening brackets
// 2. If current character is an opening one push it into stack , else it closing then return false if stack empty.Else pop that out and 
// check if current characters cvalue in map is equal to popped character .If not same same return false.
// 3.Finally after going through each character , if stack is empty return true,else false.
import java.util.HashMap;
import java.util.Stack;

public class validParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        HashMap<Character,Character> map = new HashMap<Character,Character>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        for(int i = 0; i<s.length();i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                char top = stack.isEmpty() ? '#' : stack.pop();
                if(top != map.get(c) )
                    return false;
            }
            else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
