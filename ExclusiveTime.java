import java.util.List;
import java.util.Stack;

public class ExclusiveTime {
     //o(n) and o(n/2)
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];
        int prev = 0;
        for(String log: logs){
            String[] l = log.split(":");
            int processId = Integer.parseInt(l[0]);
            String type = l[1];
            int curr = Integer.parseInt(l[2]);

            if(type.equals("start")){
                //pause the prev if possible
                if(!st.isEmpty()){
                    result[st.peek()] += curr - prev;
                }

                //add curr 
                st.push(processId);
            }else{ //end process
                //since end so the curr is updated  
                curr = curr + 1;

                result[st.pop()] += curr - prev;
            }
            prev = curr;
        }
        return result;
    }
}
