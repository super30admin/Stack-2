import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions {
    public static void main(String[] args) {
        String[] s = {"0:start:0","1:start:2","1:end:5","0:end:6"};
        List<String> logs = Arrays.asList(s);
        int n = 2;
        exclusiveTime(n, logs);
    }

    public static int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];

        if(logs == null || logs.size() == 0)
            return result;

        Stack<Integer> st = new Stack<>();

        int prev = 0;
        int curr = 0;

        for(String log: logs){
            String[] splitString = log.split(":");
            curr = Integer.parseInt(splitString[2]);

            if(splitString[1].equals("start")){
                if(!st.isEmpty()){
                    result[st.peek()] += curr-prev;
                    prev = curr;
                }
                st.push(Integer.parseInt(splitString[0]));
            } else {
                result[st.pop()] += (curr + 1) - prev;
                prev = (curr + 1);
            }
        }

        return result;
    }
}

