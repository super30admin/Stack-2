//636. Exclusive Time of Functions - https://leetcode.com/problems/exclusive-time-of-functions/description/
//Time Complexity: O(n)
//Space Complexity: O(n)

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];
        int prev = 0; //to get the timestamp difference

        for(String log: logs){
            String[] splitArr = log.split(":");
            //[processId:processType:timestamp]
            int processId = Integer.parseInt(splitArr[0]);
            String processType = splitArr[1];
            int curr = Integer.parseInt(splitArr[2]);

            if(processType.equals("start")){
                if(!st.isEmpty()){
                    result[st.peek()] += curr-prev;
                }
                //push when start
                st.push(processId);
            } else{
                curr = curr + 1;
                //pop when ends
                result[st.pop()] += curr - prev;
            }
            prev = curr;
        }
        return result;
    }
}