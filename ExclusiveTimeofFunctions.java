// Time Complexity :  O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        if(logs.size() == 0) return res;
        
        Stack<Integer> st = new Stack<>();
        String[] s = logs.get(0).split(":");
        st.push(Integer.parseInt(s[0]));
        int i = 1, prev = Integer.parseInt(s[2]);
        while(i < logs.size()){
            s = logs.get(i).split(":");
            if(s[1].equals("start")){
                if(!st.isEmpty()){
                    res[st.peek()] += Integer.parseInt(s[2]) - prev;
                }
                st.push(Integer.parseInt(s[0]));
                prev = Integer.parseInt(s[2]);
            }else{
                res[st.peek()] += Integer.parseInt(s[2]) - prev + 1;
                st.pop();
                prev = Integer.parseInt(s[2]) + 1;
            }
            i++;
        }
        return res;
    }
}
