import java.util.List;
import java.util.Stack;
/*
Exclusive Time of Functions
approach: keep tracking of curTime, start and endTime for a functionID
time: O(len(logs))
space: O(n/2)
 */
public class Problem1 {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];
        int curTime = 0;

        for(String s: logs) {
            String[] stArr = s.split(":");
            if(stArr[1].equals("start")) {
                if(!st.isEmpty()) {
                    res[st.peek()]+=Integer.valueOf(stArr[2])-curTime;
                }
                st.push(Integer.valueOf(stArr[0]));
                curTime = Integer.valueOf(stArr[2]);
            }
            else {
                int pop = st.pop();
                res[pop]+=Integer.valueOf(stArr[2])-curTime+1;
                curTime = Integer.valueOf(stArr[2])+1;
            }
        }
        return res;
    }
}
