// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : For each starting task, add task it to stack and maintain a prev index to current time. For end 
/// event, compute the amount of time, the current task (i.e, on top of stack ran for), update prev to curr+1
/// (bcoz when end says event ended at timestampx, it ran through timestamp x and then ended)
class Solution { 
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        int curr = 0, prev = 0;
        Stack<Integer> st = new Stack<>();
        for(String log: logs){
            System.out.println(log);
            String logArr[] = log.split(":");
            int taskId = Integer.parseInt(logArr[0]);
            int time = Integer.parseInt(logArr[2]);
            String task = logArr[1];
            curr = time;
            if(task.equals("start")){
                if(!st.isEmpty()){
                    res[st.peek()] += curr- prev;
                }
                st.push(taskId);
                prev = curr;
            }
            else{
                res[st.peek()] += curr + 1 - prev;
                prev = curr+1;
                st.pop();
            }
        }
        return res;
    }
}