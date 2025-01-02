// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Problem1 {
    //TC:O(N)
    //SC:O(N)
    public int[] exclusiveTime(int n, List<String> logs) {
        int prevTime =0;
        int[] process = new int[n];
        Stack<Integer> st = new Stack<>();
        for(String log : logs){
            String[] logArr = log.split(":");
            Integer processId = Integer.parseInt(logArr[0]);
            Integer currTime  = Integer.parseInt(logArr[2]);
            if(logArr[1].equals("start")){
                //pause the previous process
                if(!st.isEmpty()){
                    process[st.peek()] += currTime - prevTime;

                }
                st.add(processId);
                prevTime = currTime;
            }else{
                int endTime = currTime +1;//because the entire end time is cosumed .. if a task starts at 0 and ends at 0 that means it
                //consumed the entire time
                process[processId] += endTime - prevTime;
                st.pop();
                prevTime = endTime;
            }

        }
        return process;
    }
}
