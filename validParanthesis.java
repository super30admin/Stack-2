
//Time Complexity : O(N)
//Space Complexity : O(N)
/**
 * Iterate twice the size of the array to satisfy circular array condition. At
 * each iteration, do i%n so that i remains in length of n. If the peek <
 * current element, update peek index in answer array with the current element
 * and then push the current index % n. Return answer array.
 *
 */
    class Solution {
    public boolean isValid(String s) {
        //null
        if(s == null ||s.length() == 0) return false;
        if(s.length() % 2 != 0) return false;
        Stack<Character> st = new Stack<>();
        for(int i=0;i< s.length();i++){
            char c = s.charAt(i);
            if(c == '(') st.push(')');
            else if(c == '[') st.push(']');
            else if(c == '{') st.push('}');
            else if(st.isEmpty() || c != st.pop() ) return false;
        }
            
        if(!st.isEmpty()) return false;
        return true;
        
    }
}
