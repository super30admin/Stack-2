import java.util.List;
import java.util.Stack;

// Time Complexity: O(n) where n is the number of logs
// Space Complexity: O(n) where n is the number of logs
class ExclusiveTime {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> st = new Stack<>();

        int curr = 0, prev = 0;
        int[] res = new int[n];
        for(int i = 0; i < logs.size(); i++){
            String log = logs.get(i);
            String[] s = log.split(":");
            int taskId = Integer.parseInt(s[0]);
            curr = Integer.parseInt(s[2]);

            if(s[1].equals("start")){
                if(!st.isEmpty()){
                    res[st.peek()] += curr - prev;
                }
                st.push(taskId);
                prev = curr;
            }else{
                res[st.peek()] += curr + 1 - prev;
                st.pop();
                prev = curr+1;
            }
        }
        return res;
    }
}
