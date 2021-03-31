// Time complexity - O(n)
// Space complexity - O(1) - constant
// works on leetcode

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        int curr = 0;
        int prev = 0;
        
        int[] output = new int[n];
        
        for(String log: logs){
            String[] split = log.split(":");
            
            curr = Integer.parseInt(split[2]);
            
            if(split[1].equals("start")){
            // For start, push it into the stack and update prev and curr
                if(!stack.isEmpty()){
                    output[stack.peek()] += curr - prev;
                    prev = curr;
                }
                stack.push(Integer.parseInt(split[0]));
                
            }
            else{
             // For end, pop and update the output
                output[stack.pop()] += curr - prev + 1;
                prev = curr + 1;
            }
        }
        return output;
    }
}
