// class ValidParentheses {
//     Stack<Character> st = new Stack<>();
//     public boolean isValid(String s) {
//         if(s.length()%2 != 0) {
//             return false;
//         }
//         for(int i = 0; i < s.length(); i++) {
//             if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
//                 st.push(s.charAt(i));
//             } 
//             else if(s.charAt(i) == ')') {
//                 if(st.size() == 0) {
//                     return false;
//                 } else if(st.peek() == '(') {
//                     st.pop();
//                 } else 
//                     return false;
//                 }
//             else if (s.charAt(i) == ']') {
//                 if(st.size() == 0) {
//                     return false;
//                 } else if (st.peek() == '[') {
//                     st.pop();
//                 } else 
//                     return false;
//             } else if(s.charAt(i) == '}') {
//                 if(st.size() == 0) {
//                     return false;
//                 } else if(st.peek() == '{') {
//                     st.pop();
//                 } else 
//                     return false;
//             }
//         }
//         if(st.size() != 0) {
//             return false;
//         }
//         return true;
//     }
// }

class ValidParentheses {
    Stack<Character> st = new Stack<>();
    public boolean isValid(String s) {
        for(int i=0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                st.push(')');
            } else if(c == '{') {
                st.push('}');
            } else if(c == '[') {
                st.push(']');
            } else if(st.isEmpty() || st.pop() != c) return false;
        }
        return st.isEmpty();
    }
}