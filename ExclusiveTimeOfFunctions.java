// Time Complexity :O(n) where n is the number of functions
// Space Complexity :O(n) where n is the number of functions
// Did this code successfully run on Leetcode :yes
import java.util.List;
import java.util.Stack;
public class ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {

        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];
        int previousTime = 0;

        for(String log : logs){

            String[] currentLog = log.split(":");
            int currentFunction = Integer.parseInt(currentLog[0]);
            String currentAction = currentLog[1];
            int currentTime = Integer.parseInt(currentLog[2]);

            if(currentAction.compareTo("start") == 0){
                if(!st.isEmpty()){
                    int top = st.peek();
                    result[top] += currentTime - previousTime;
                }
                st.push(currentFunction);
                previousTime = currentTime;
            }else{
                int top = st.pop();
                result[top] += currentTime + 1 - previousTime;
                previousTime = currentTime + 1;
            }
        }
        return result;
    }
}
