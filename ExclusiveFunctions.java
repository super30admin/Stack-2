// Time Complexity : 0(n)
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class ExclusiveFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {

        //initialize result array and stack
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        //prev variable to see last time processed
        int prev = 0;

        //iterate through the logs
        for(String log: logs) {
            //split logs into arr of 3
            String[] arr = log.split(":");
            //if it is start of a function
            if(arr[1].equals("start")) {
                //if stack is not empty then
                //add execution time for function present on top of the stack
                if(!stack.isEmpty())
                    result[stack.peek()] += Integer.parseInt(arr[2]) - prev;
                //push the current function
                stack.push(Integer.parseInt(arr[0]));
                //update value of prev
                prev = Integer.parseInt(arr[2]);
            } else {    //or if it is end of a function
                //pop top function and update execution time
                result[stack.pop()] += Integer.parseInt(arr[2]) - prev + 1;
                //update value of prev
                prev = Integer.parseInt(arr[2]) + 1;
            }
        }
        return result;
    }
}