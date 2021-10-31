package Stack2;

import java.util.List;
import java.util.Stack;
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes

public class ExclusiveTime {
    public int[] exclusiveTime(int n, List<String> logs) {
        int currStart = 0;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for(int i=0; i< logs.size(); i++){
            String[] s = logs.get(i).split(":");
            int id = Integer.parseInt(s[0]);
            int time = Integer.parseInt(s[2]);
            if(s[1].equals("start")){
                res[st.peek()] += time - currStart;
                currStart = time;
                st.push(id);
            } else {
                st.pop();
                res[id] += time - currStart + 1;
                currStart = time+1;
            }
        }
        return res;
    }
}
