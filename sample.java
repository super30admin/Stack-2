// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> s = new Stack<>();
        int curr = 0;
        int prev = 0;
        int[] res = new int[n];
        for (String log : logs) {
            String[] str = log.split(":");
            curr = Integer.parseInt(str[2]);
            if (str[1].equals("start")) {
                if (!s.isEmpty()) {
                    res[s.peek()] += curr - prev;
                }
                s.push(Integer.parseInt(str[0]));
                prev = curr;
            } else {
                res[s.pop()] += curr + 1 - prev;
                prev = curr + 1;
            }
        }

        return res;
        
    }
}


//valid paranthesis

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                st.push(')');
            }
            else if(c == '{') {
                st.push('}');
            }
            else if(c == '[') {
                st.push(']');
            }
            else {
                if(st.isEmpty() || (st.peek() != c)) {
                    return false;
                } else {
                    st.pop();
                }
            }
        }
        return st.isEmpty();
    }
}
