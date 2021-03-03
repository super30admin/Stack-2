import java.util.*;

class ExclusiveTime{
    
    public int[] exclusiveTime(int n, List<String> logs) {

        int res[] = new int[n];
        Stack<Integer> st = new Stack();
        int prev = 0;

        for (String s: logs){
            String input[] = s.split(":");
            int id = Integer.valueOf(input[0]);
            int curr = Integer.valueOf(input[2]);
            String phase = input[1];
            
            if (phase.equals("start")){
                if (!st.isEmpty()){
                    res[st.peek()] += curr - prev;
                    prev = curr;
                }
                st.push(id);
            }
            else{
                res[st.pop()] += curr - prev + 1;
                prev = curr + 1;
            }

        }

        return res;
    }
}