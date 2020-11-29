class Solution {// time of O(logs) and space of O(n/2)
    public int[] exclusiveTime(int n, List<String> logs) {
        int prev= 0;
        int curr = 0;
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n]; 
        
        //iterating over each entry of logs 
        for(String log : logs){
            String[] record = log.split(":");
            curr = Integer.parseInt(record[2]);
            //if its start or
            if(record[1].equals("start")){
                if(!stack.isEmpty()){
                    result[stack.peek()] += curr-prev;
                }
                stack.push(Integer.parseInt(record[0]));
                prev = curr;
            }
            //if its end
            else{
                result[stack.peek()] += curr - prev +1;
                stack.pop();
                prev = curr+1;
            }
        }
        return result;
    }
}