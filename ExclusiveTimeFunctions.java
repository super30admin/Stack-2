//Time complexity : O(L) ; L- no. of logs
//Space Complexity : O(L) ; L- no. of logs
//Did it run on leetcode : yes

import java.util.List;
import java.util.Stack;

public class ExclusiveTimeFunctions {

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        if(logs == null || logs.size() == 0) return result;
        Stack<Integer> st = new Stack<>();
        int prev = 0;

        for(String log: logs){
            String[] splitArr = log.split(":"); //["0","start","0"]
            int currTimeStamp = Integer.parseInt(splitArr[2]);
            if(splitArr[1].equals("start")){
                if(!st.isEmpty()){
                    //count prev of prev process as its stopped
                    result[st.peek()] += (currTimeStamp - prev);
                    prev = currTimeStamp;
                }
                st.push(Integer.parseInt(splitArr[0]));
            }else{
                //remove task from stack which is now complete
                result[st.pop()] += (currTimeStamp + 1 - prev); //push taskID onto stack
                prev = currTimeStamp + 1;
            }
        }
        return result;
    }
}
