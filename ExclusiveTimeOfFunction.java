//Time Complexity O(N)
//Space Complexity O(N)
//Leetcode tested

import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunction {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        int lastLogTimeStamp = -1;
        int ans[] = new int[n];

        for (String log: logs) {
            String[] arr=  log.split(":");
            int funcId = Integer.parseInt(arr[0]);
            boolean isStart = "start".equals(arr[1]);
            int timestamp = Integer.parseInt(arr[2]);

            if(!isStart) timestamp += 1;

            if(!stack.isEmpty()){
                int currentFunc = stack.peek();
                ans[currentFunc] += timestamp - lastLogTimeStamp;
            }

            if(isStart) stack.push(funcId);
            else stack.pop();
            lastLogTimeStamp = timestamp;
        }
        return ans;
    }
}
