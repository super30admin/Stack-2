import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFuctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        // TC:O(n) //length of logs
        // SC:O(n/2)
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];
        int prevTime = 0;
        for(String log : logs){
            String[] process = log.split(":");
            int currTask = Integer.parseInt(process[0]);
            int currTime = Integer.parseInt(process[2]);
            if(process[1].equals("start")){
                //pause the previous process
                if(!st.isEmpty()){
                    result[st.peek()] += currTime - prevTime;
                }

                st.push(currTask);
            }else{
                //curr = curr + 1
                currTime = currTime + 1;
                result[st.pop()] += currTime - prevTime;
            }
            prevTime = currTime;
        }
        return result;
    }
}
