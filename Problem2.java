import java.util.Stack;
/*
Valid Parenthesis
approach: for every close brace we see, peek should be open brace of same type
time: O(len(s))
space: O(len(s))
 */
public class Problem2 {
    public boolean isValid(String s) {
        if(s==null || s.length()==0) return true;

        Stack<Character> st = new Stack<>();

        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);

            if(!st.isEmpty()) {
                if(c==')') {
                    if(st.peek()=='(') {
                        st.pop();
                        continue;
                    }
                }
                if(c==']') {
                    if(st.peek()=='[') {
                        st.pop();continue;
                    }
                }
                if(c=='}') {
                    if(st.peek()=='{') {
                        st.pop();continue;
                    }
                }

            }
            st.push(c);
        }

        return st.isEmpty()?true:false;
    }

    public static void main(String[] args) {
        Problem2 problem2 = new Problem2();
        problem2.isValid("(])");
    }
}
