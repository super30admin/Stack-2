// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
     int cur =0;   
     int prev =0;
     Stack<Integer> stack = new Stack<>();
     int[] result = new int[n];
     for(String log : logs){
        String[] splited = log.split(":");
        cur = Integer.parseInt(splited[2]);
        if(splited[1].equals("start")){
            if(!stack.isEmpty()){
                result[stack.peek()]+=cur-prev;
            }
            stack.push(Integer.parseInt(splited[0]));
            prev=cur;
        }
        else{
                            result[stack.peek()]+=cur-prev+1;
                            stack.pop();
                            prev=cur+1;
        }
     }
return result;
    }
}