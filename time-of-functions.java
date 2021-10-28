//Time complexity: O(N)
//Space complexity: O(N)
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        //store task id to the stack
        Stack<Integer> stack = new Stack<>();
        int prev = 0;
        int curr = 0;
        int[] result = new int[n];
        for(String log: logs) {
            String[] record = log.split(":");
            curr = Integer.parseInt(record[2]);
            //if task is "start" then time is curr - prev  
            //and prev is set to curr. 
            //task start at begining of timestamp.
            if(record[1].equals("start")) {
                if(!stack.isEmpty()) {
                    result[stack.peek()] += curr - prev;
                }
                stack.push(Integer.parseInt(record[0]));
                prev = curr;
            }
            //if funtion is "end" then time is 
            //curr - prev +1 and prev is set to curr +1 
            //because function is ending at the end of timestamp 
            //sso other process cant start at same curr time.
            else {
                result[stack.pop()]+= curr - prev +1;
                prev = curr + 1;
            }
        }
        return result;
    }
}