import java.util.List;
import java.util.Stack;
//TC-O(1) SC-O(n)
public class ExclusiveTime {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<int []> st = new Stack<>();
        int res [] = new int [n];
        for(String s: logs){
            String[] s1 = s.split(":");
            int id = Integer.parseInt(s1[0]);
            String se = s1[1];
            int t = Integer.parseInt(s1[2]);
            if(se.equals("start")){
                st.push(new int []{id,t});
            }
            else{
                int ans = t - st.pop()[1]+1;
                res[id] += ans;
                if(!st.isEmpty()){
                    res[st.peek()[0]] -= ans;
                }
            }

        }
        return res;
    }
}
