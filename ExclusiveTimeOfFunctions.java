// Time Complexity : O(n)
// Space Complexity : O(n*k) k is some constant
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {

        if(logs == null || logs.size() == 0)
            return new int[0];

        int[] result = new int[n]; //n is number of tasks

        //to keep task ids, so we know which is the current task, all the lower ones are paused
        Stack<Integer> stack = new Stack();
        int prev = 0; //time interval of previous task
        int curr = 0; //time interval of current task

        for(String log : logs) {

            String[] logArr = log.split(":");

            curr = Integer.parseInt(logArr[2]); //time

            //start log
            if(logArr[1].equals("start")) {

                if(!stack.isEmpty()) {
                    //add time for tak at top of stack which will be paused
                    result[stack.peek()] += curr - prev;
                }
                //push current task in stack
                stack.push(Integer.parseInt(logArr[0]));
                //move prev forward
                prev = curr;

            } else {

                //pop the current task and add its time
                result[stack.pop()] += curr + 1 - prev;
                //move prev
                prev = curr + 1; //since its end of task, we have to consider the whole interval box, not just its start point
            }
        }
        return result;
    }
}
