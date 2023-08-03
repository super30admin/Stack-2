import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        String current = logs.get(0);
        String[] init = current.split(":");

        int lastFunctionId = Integer.valueOf(init[0]);
        int lastTimeStamp = Integer.valueOf(init[2]);
        st.push(lastFunctionId);

        for(int i=1; i< logs.size(); i++){
            current = logs.get(i);
            String[] currArr = current.split(":");

            int currentFunctionId = Integer.valueOf(currArr[0]);
            int currentTimeStamp = Integer.valueOf(currArr[2]);
            if("start".compareTo(currArr[1]) == 0){
                st.push(currentFunctionId);
                result[lastFunctionId] += currentTimeStamp - lastTimeStamp;
                lastTimeStamp = currentTimeStamp;
                lastFunctionId = currentFunctionId;
            }else{
                //end
                int top = st.pop();
                result[top] += currentTimeStamp - lastTimeStamp + 1;
                lastTimeStamp = currentTimeStamp + 1;
                if (!st.empty()) {
                    lastFunctionId = st.peek();
                }
            }
        }
        return result;
    }
}
