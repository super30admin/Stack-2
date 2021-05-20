// TC - O(number of logs)
// SC - O(number of logs/2)

// LC - 636

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        
        int prev = 0;
        int curr = 0;
        // We take a stack and split the each log. if it is a start, we push onto stack else we pop and add into result array
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(String log : logs){
            String[] logData = log.split(":");
            curr = Integer.parseInt(logData[2]);
            if(logData[1].equals("start")){
                if(!stack.isEmpty()){
                    result[stack.peek()] += curr - prev;
                    prev = curr;
                }
                stack.push(Integer.parseInt(logData[0]));
            }else{
                result[stack.pop()] += curr - prev + 1;
                prev = curr + 1;
            }
        }
        
        return result;
    }
}