// TC: O(n)
// SC: O(n)

import java.util.*;

public class ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        int ans[] = new int[n];
        int len = logs.size();
        Stack<Integer> stack = new Stack<>();
        int lastBreak = 0;
        for(int i=0;i<len;i++){
            String[] log = logs.get(i).split(":");
            int id = Integer.parseInt(log[0]);
            int time =  Integer.parseInt(log[2]);
            if(stack.isEmpty()){
                stack.push(id);
                lastBreak = time;
            } else {
                int lastID = stack.peek();
                if(log[1].equals("start")){
                    int diff = time - lastBreak;
                    ans[lastID] += diff;
                    lastBreak = time;
                    stack.push(id);
                } else {
                    int diff = time - lastBreak + 1;
                    ans[lastID] += diff;
                    lastBreak = time+1;
                    stack.pop();
                }
            }
        }
        return ans;
    }
}
