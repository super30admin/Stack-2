// Time Complexity : O(l)
// Space Complexity : O(l)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/*
when we will encounter the start log, we will see if any prev start time was recorded, if so we would store the diff at the prev indx in teh result array
when we will encounter the end log, we will pop out the top elemeng of the stackt and store the diff at the top id with this exp end-start+1, and will male prev = end+1;


*/
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {

        int[] result = new int[n];

        Stack<Integer> stack = new Stack<Integer>();        

        Integer prev = null;

        for(String s: logs){
            String[] cur = s.split(":");
            if(cur[1].charAt(0) == 's' && prev!=null){ // if its a start log
            if(!stack.isEmpty()){ // if stack is empty, then just push the element on the stack
            result[stack.peek()] += Integer.valueOf(cur[2]) - prev; // as prev id would be stopped when a new ones come, so we will calculate the prev time
            prev = Integer.valueOf(cur[2]); // now the prev would become current
            }
            stack.push(Integer.valueOf(cur[0])); // pushing new start
            }
            else if(cur[1].charAt(0) == 'e' && prev!=null){
                result[stack.pop()] += Integer.valueOf(cur[2]) - prev +1; // // poping id on the top of the stack 
                prev = Integer.valueOf(cur[2]) +1; // prev would be end+1
            }
            if(prev == null){
                prev = Integer.valueOf(cur[2]);
                stack.push(Integer.valueOf(cur[0])); // pushing new start
            }

        }
        
    return result;
    }

}
