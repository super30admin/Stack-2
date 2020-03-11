//Time Complexity: O(n)
//Space Complexity: O(n)

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack <Integer> stack = new Stack<>();
        int [] result = new int[n];
        //to keep track of prev processes
        int prev = 0;
        //for each log in logs
        for(String log : logs){
            String[] arr = log.split(":");
            //timestamp of each process is considered as curr
            int curr = Integer.parseInt(arr[2]);
            //case1: when the process has start time
            if(arr[1].equals("start")){
                //edge case if stack is not empty
                if(!stack.isEmpty()){
                    result[stack.peek()] += curr - prev;
                }
                //push process if is kept on hold; has no hold
                stack.push(Integer.parseInt(arr[0]));
                prev = curr;
            }else{
                //case2: when the process has end time; pop
                //and subtract it from prev to get total timestamp + 1
                result[stack.pop()] += curr - prev + 1;
                prev = curr + 1;
            }
        }
        return result;
    }
}