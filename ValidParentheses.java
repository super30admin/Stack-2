import java.util.*;

public class ValidParentheses {
	
	/*//TC - o(n)
    //SC-o(n)
    public boolean isValid(String s) {
        
        if(s == null || s.length() == 0)
            return false;
        
        //create hashmap with closing brackets as key
        //bcs as soon as we hit closing bracket we will pop and validate both characters
        //o(1) operations
        HashMap<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        
        Stack<Character> st = new Stack<>();
        
        for(int i =0; i<s.length();i++){
            char c= s.charAt(i);
            
            //map doesn’t contains the key that is it is the opening bracket
            //just push it to stack
            if(!map.containsKey(c)) {
                st.push(c);
            } else {
                //as soon as we hit closing bracket pop and validate
                char ch = !st.isEmpty() ? st.pop() : '#';
                if(map.get(c) != ch)
                    return false;
            }
        }
        //at the end check stack has any brackets or not
        //if it has means closing brackets were missing
        //return false
        return st.isEmpty();
    } */
	
	//TC - o(n)
    //SC-o(n)
    public boolean isValid(String s) {
        
        if(s == null || s.length() == 0)
            return false;
        
        Stack<Character> st = new Stack<>();
        
        for(int i =0; i<s.length();i++){
            char c= s.charAt(i);
            
            //push closing brackets for openning brackets
            if(c == '(') st.push(')');
            else if(c == '{') st.push('}');
            else if(c == '[') st.push(']');
            //if closing bracket pop and check both are equal or not
            else{
                //not equal or stack is empty return false
                if(st.isEmpty() || c != st.pop())
                    return false;
            }
        }
        //at the end check stack has any brackets
        //if it has means closing brackets were missing
        //return false
        return st.isEmpty();
    }

}
