// Time Complexity : O(n) n is size of logs list
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Approach : We split the input String into given 3 parts and capture them accordingly. If the operation is start, we calculate the time
// from previous one to the current one and add to result. If the operation is end, as end will be the tails of the timestamp, we add 1 to the
// current timestamp and calculate the time and pop it from stack as it ended. We use stack here because we are concerned about the start
// and end of last started functionId.

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];
        int prev = 0;

        for(String log : logs){
            String[] splitArr = log.split(":"); //split the 3 required parameters
            int functionId = Integer.parseInt(splitArr[0]);
            String type = splitArr[1];
            int curr = Integer.parseInt(splitArr[2]);

            if(type.equals("start")){
                if(!st.isEmpty()){ //when new function is starting
                    result[st.peek()] += curr - prev; //time calculation
                }
                st.push(functionId);
            }else{ //end operation
                curr = curr + 1; //as end will be towards the tail so 1 step ahead
                result[st.pop()] += curr - prev; //time calculation and pop from stack
            }

            prev = curr; //update previous
        }

        return result;
    }
}
