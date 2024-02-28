class Solution {
    //TC: O(length of logs)
    //SC: O(length of logs)
    public int[] exclusiveTime(int n, List<String> logs) {
        int prev = 0;
        int [] result = new int[n];
        Stack<Integer> st = new Stack<>();
        for(String log: logs){
            String [] splitlog = log.split(":");
            int taskId = Integer.parseInt(splitlog[0]);
            int curr = Integer.parseInt(splitlog[2]);
            if(splitlog[1].equals("start")){
                if(!st.isEmpty()){
                     result[st.peek()] += curr-prev;                    
                }
                st.push(taskId);
                prev = curr;              
            }else{
                result[st.pop()] += curr + 1 - prev;
                prev = curr + 1;
            }
        }
        return result;
    }
}
