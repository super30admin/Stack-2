
// Time Complexity : O(n) // n is size of logs list
// Space Complexity : O(n) // n is size of logs list
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
/*
 * We iterate over the list of logs and push the functions that are started into the stack and keep the recent on top 
 * and update when a new fucntion starts, for end times, we calculate and update result array and continue the the 
 * function on top of stack.
 */
// Your code here along with comments explaining your approach
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<int[]> st = new Stack(); // function, start, execution time
        int[] result = new int[n];
        for(int i = 0; i < logs.size(); i++){
            String[] log = logs.get(i).split(":");
            if(log[1].equals("start")){
                if(!st.empty()){
                    // update the execution time of previous element 
                    int[] top = st.pop();
                    top[2] += Integer.valueOf(log[2])-top[1];
                    st.push(top);
                }
                st.push(new int[]{Integer.valueOf(log[0]),Integer.valueOf(log[2]),0});
            }else {
                // calculate value (end-start+1 + exec time) and update result 
                int[] curr = st.pop();
                result[curr[0]] += Integer.valueOf(log[2]) - curr[1] + 1 + curr[2];
                //update start time if elements in stack
                 if(!st.empty()){
                    // update the execution time of previous element 
                    int[] top = st.pop();
                    top[1] = Integer.valueOf(log[2]) + 1;
                    st.push(top);
                }
            }
        }
        return result;
    }
}