
//Time Complexity : O(N)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * Take a stack and push to the stack if its a start. Maintain an array for
 * result. Also maintain a previous time to track the call time taken.
 * Initially, if the stack is empty, push the current start time. From next
 * iteration, if its a start, update the peek index with total difference of
 * curr time and previous time. Then push to the stack. If it is an end, then
 * pop out the top element and update its time with difference of current time
 * and previous time + 1. finally return the result array.
 *
 */

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        //null
        if(logs == null ) return new int[0];
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        int prev = 0;
        for(String log: logs){
            String[] strArr = log.split(":");
            int task = Integer.parseInt(strArr[0]);
            int curr = Integer.parseInt(strArr[2]);
            //start
            if(strArr[1].equals("start")){
                if(!st.isEmpty()){
                    result[st.peek()] += curr - prev;
                }
                prev = curr;
                st.push(task);
            } else{  //end
                result[st.pop()] += (curr+1) - prev;
                prev = curr+1; 
            }                
        }
        return result;
    }
}
