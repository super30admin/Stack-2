//Time complexity: O(n + m) , m = logs.length.
//Space complexity: O(n) n = logs. 


class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if(n == 0) return new int[]{};
        
        Stack<Integer> s = new Stack<>();
        int[] result = new int[n];
        int curr = 0;
        int prev = 0;
        for(String log: logs){
            String[] splitArray = log.split(":");
            
            String process = splitArray[1];
            curr = Integer.parseInt(splitArray[2]);
            if(process.equals("start")){
                if(!s.isEmpty()){
                    result[s.peek()] += curr - prev;
                }
                int functionId = Integer.parseInt(splitArray[0]);
                s.push(functionId);
                prev = curr; 
            }
            else{
                result[s.pop()] += curr + 1 - prev; 
                prev = curr + 1;
            }
        }
        return result;
    }
}