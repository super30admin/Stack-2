/*
The time complexity is O(logs) where logs is the size of logs list. The space complexity is O(n).

The intuition here is to store the id of log into stack where we see start in the log. While storing the id we should even check if the
stack is empty or not. If not we need to store the previous id's time and add the present id to the stack. If we see ene, we pop out the
top of the stack and store its run time. We use prev to store the top of the stack id's start time.

Yes, the solution passed all the test cases in leetcode.
 */
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {

        //Stack to store the id's
        Stack<Integer> stack = new Stack<>(); int prev = 0;

        //ret array to store the time of each id.
        int[] ret = new int[n];
        for(String log:logs){
            String[] each = log.split(":");

            //Get present log id
            int id = Integer.parseInt(each[0]);
            String cond = each[1];

            //Get present log time
            int time = Integer.parseInt(each[2]);
            if(cond.equals("start")){
                if(!stack.isEmpty()){
                    //storing the top element's run time.
                    ret[stack.peek()]+=time-prev;
                    prev = time;
                }
                stack.add(id);
            }
            else{
                ret[stack.pop()]+=time-prev+1;
                prev = time+1;
            }
        }

        return ret;
    }
}