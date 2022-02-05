import java.util.List;
import java.util.Stack;

// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Sample {
    public boolean isValid(String s) {
        //o(n) time and o(n) space
        if(s == null || s.length() == 0) return true;
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') st.push(')');
            else if(s.charAt(i) == '[') st.push(']');
            else if(s.charAt(i) == '{') st.push('}');
            else if (st.isEmpty() ||s.charAt(i) != st.pop()) return false;
            
        }
        return st.isEmpty();
    }

    class Solution {
        public int[] exclusiveTime(int n, List<String> logs) {
            //o(n) time and o(n) space

            int[] res = new int[n];
            if(logs == null || logs.size() == 0) return res;
            Stack<Integer> st = new Stack<>();
            int prev = 0;
            for(String log: logs){
                String[] splitArr = log.split(":");
                int curr = Integer.parseInt(splitArr[2]);
                if(splitArr[1].equals("start")){
                    if(!st.isEmpty()){
                        res[st.peek()] += curr - prev;
                    }
                    prev = curr;
                    st.push(Integer.parseInt(splitArr[0]));
                } else {
                    res[st.pop()] += curr + 1 - prev;
                    prev = curr+1;
                }
            }
            return res;
            
        }
    }
}