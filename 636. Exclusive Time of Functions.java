// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//we need to see whether function call is open or closed, kind of parenthesis problem so its clear that we need to use stack here.
//we traverse over the logs and split each element into 3 parts, we keep prev and curr so that we can calculate thetotal period the functio was runing.
//each time we occur start in logs, we add the difference to previous(top of stack) inex in result array, and add this new function to stack. prev==curr now.
//If we get end, then we do curr+1 - prev as curr is to be added in the execution time. if something startsb at 4 and ends at 5. answer is not 5-4, its 6-4 as 5th minute is consumed, so we do this and set prev to curr+1 as well.

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int prev = 0;

        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(String log : logs){
            String [] arr = log.split(":");
            int curr = Integer.parseInt(arr[2]);
            if(arr[1].equals("start")){
                if(!stack.empty()){
                    result[stack.peek()] += curr - prev;
                    prev = curr;
                }
                stack.push(Integer.parseInt(arr[0]));
            }else{
                result[stack.pop()] += curr+1 - prev;
                prev = curr+1;
            }

        }
        return result;
    }
}