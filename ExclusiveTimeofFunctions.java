/*
* Approach: 
    - The idea is to make sure the end is not just the end of the current time but also the beginning of the next time so keep two pointers to keep track of curr and prev time
    - By keeping that in mind, if we encounter start, that means new function has started executing
        - add that to the stack
        - calculate the time that the task has taken curr - prev and add it to the already calculated resultant value
        - change the prev pointer to curr time
    - For when we encounter "end"
        - pop the top of the stack as that functionid is done executing
        - calculate the time the function has taken: curr + 1 - prev -> + 1 becuase that time of unit where the function has ended has been utilized 
        - change prev to curr + 1
    - TC: O(n) -> iterate over logs
    - SC: O(n) -> stack space for storing function ids
 */
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];
        int prev = 0;

        for(String log : logs){
            String[] splitArr = log.split(":");
            int funId = Integer.parseInt(splitArr[0]);
            int curr = Integer.parseInt(splitArr[2]);

            if(splitArr[1].equals("start")){
                // push it to the stack and calculate time taken 
                if(!stack.isEmpty()){
                    res[stack.peek()] += curr - prev;
                }
                prev = curr;
                stack.push(funId);
            }
            else{
                // for end, we need to pop the top of the stack, and curr should be curr + 1 and prev should also be curr + 1
                res[stack.pop()] += curr + 1 - prev;
                prev = curr + 1;
            }
        }
        return res;
    }
}
