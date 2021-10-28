// Time Complexity: O(n)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        // return empty array in case of empty or null input list
        if(logs == null || logs.size()== 0) return new int[n];
        // initialize the result array to be returned
        int[] result = new int[n];
        // initialize stack and previous pointer
        Stack<Integer> st = new Stack<>();
        int previous = 0;
        // iterate through the logs list
        for(String log : logs){
            // split each log string
            String[] splitArr = log.split(":");
            // initialize current pointer
            int current = Integer.parseInt(splitArr[2]);
            // if function has started being executed
            if(splitArr[1].equals("start")){
                // check if it is the first element in the stack, then update the result array
                if(!st.isEmpty()) result[st.peek()] += current - previous;
                // update previous pointer
                previous = current;
                // push the function in the stack
                st.push(Integer.parseInt(splitArr[0]));
            } else {
                // if functions has ended after executing
                // update the result array
                result[st.pop()] += current + 1 - previous;
                // update the previous pointer
                previous = current + 1;
            }
        }
        // return the result array
        return result;
    }
}