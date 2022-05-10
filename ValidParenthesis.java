import java.util.Stack;

//Time Complexity : O(n)
//Space Complexity : O(n)
public class ValidParenthesis {	
	/**Approach: Stack**/
	public boolean isValid(String s) {
		if(s==null || s.length()==0) return false;
        Stack<Character> st= new Stack<>();
        for(char ch: s.toCharArray()){        	
            if(ch == '(') st.push(')');
            else if(ch == '{') st.push('}');
            else if(ch == '[') st.push(']');
            else if(st.isEmpty() || ch != st.pop()) return false;
        }
        return st.isEmpty();
    }

	public static void main (String[] args) {
		ValidParenthesis ob = new ValidParenthesis();
		String str="()";//"()[]{}";//"(]";				
		System.out.println("Is valid string : "+ ob.isValid(str));
	}
}
