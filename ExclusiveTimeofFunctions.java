
/*
time complexity: O(n)
space complexity: O(n)

*/
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        
        int[]result = new int[n];
        //edge case
        if(logs.size() == 0 || logs == null)return result;
        
        Stack<Integer> stack = new Stack<>();
        
        //"{function_id}:{"start" | "end"}:{timestamp}"
        int prev =0;
        
        for(int i = 0; i < logs.size();i++){
            String[] currLog = logs.get(i).split(":");
            
            int id = Integer.parseInt(currLog[0]);
            int curr =Integer.parseInt(currLog[2]);
            //if start push the function id in stack
            if(currLog[1].equals("start")){
                //push the curr function id in stack
                if(!stack.isEmpty()){
                    result[stack.peek()] += curr-prev;
                    prev = curr;
                }
                stack.push(id);
            }else{
                //conusming the current moment then subtracting prev
                result[stack.pop()] += curr + 1 - prev;
                prev = curr+1;
            }
        }
        
        return result;
    }
}