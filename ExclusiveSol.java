//TC: O(n)
//SC: O(n)
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        
        int curr =0, prev =0;
        int[] output = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(String log:logs)
        {
            String[] split = log.split(":");    //Traversing through each log, split the log. Intialize prev and curr to track of previous and current value
            curr = Integer.parseInt(split[2]); //If log status is start and stack is empty just add the log id to stack else peek the stack value and add the old execution value to it's output.
            if(split[1].equals("start"))        //if the status is end pop the value out of stack and add the execution value to output.
            {
                if(!stack.isEmpty())
                {
                    output[stack.peek()]+=curr-prev;
                    prev = curr;
                }
                stack.add(Integer.parseInt(split[0]));
            }
            else
            {
                output[stack.pop()]+=curr-prev+1;
                prev=curr+1;
            }
        }
        return output;
        
    }
}