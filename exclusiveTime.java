// Time Complexity: O(max(n, logscount))
// Space Complexity: O(logsCount/2) in worst case scenario for stack
// Idea here is to use stack for holding id whenever a task is started,
// when task ends pop it from stack and record the difference of end and start in result
// when a task is paused, record the pause time - start in result and keep adding all intervals task
// was worked on and finally add end- last start time and add to existing result
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if(logs==null || logs.size()==0) return new int[n];
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        int prev = 0;
        for(String log: logs) {
            String[] currLog = log.split(":");
            int currTime = Integer.parseInt(currLog[2]);
            if(currLog[1].equals("start")) {
                if(!st.isEmpty()){
                    result[st.peek()] += currTime-prev;
                }
                prev = currTime;
                st.push(Integer.parseInt(currLog[0]));
            } else {
                result[st.pop()] +=currTime-prev+1;
                prev = currTime+1;
            }
        }
        if(!st.isEmpty()) return new int[n];
        return result;
    }
}