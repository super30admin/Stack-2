import java.util.List;
import java.util.Stack;

public class ExclusiveTimeofFuncs 
 {
    public int[] exclusiveTime(int n, List<String> logs) {

        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];
        int curTime = 0;
        int prevTime = 0;
        for(String log : logs){
            String[] str = log.split(":");
            int curtask = Integer.parseInt(str[0]);
            curTime = Integer.parseInt(str[2]);
            if(str[1].equalsIgnoreCase("start")){
                if(!st.isEmpty()){
                     result[st.peek()]+= curTime - prevTime;
                }
                st.push(curtask);
                prevTime = curTime;

               
            }else{ //end task
                result[st.pop()]+= curTime +1 - prevTime; //
                prevTime = curTime +1;
            }
        }

        return result;
    }
}
