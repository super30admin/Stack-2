// Time Complexity : O(n), n = size of logs
// Space Complexity : O(n/2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : Use a stack to record which process has started and then add the difference between the timestamps to that process's result. If an end is encountered pop from the stack to denote as process completed, add the difference between the timestamps + 1 to that process's result. 

public class ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        if(n == 0 || logs.size() == 0) return result;
        
        Stack<Integer> st = new Stack<>();
        
        int prev = 0;
        
        for(int i = 0; i < logs.size(); i++){
            String[] curr = logs.get(i).split(":");
            int timestamp = Integer.parseInt(curr[2]);
            
            if(curr[1].equals("start")){
                if(!st.isEmpty()){
                    result[st.peek()] = result[st.peek()] + timestamp - prev;
                } 
                st.add(Integer.parseInt(curr[0]));
                prev = timestamp;
                
            } else{
                int idx = st.pop();
                result[idx] = result[idx] + timestamp - prev + 1;
                prev = timestamp + 1;
            }
        }
        
        return result;
    }
}
