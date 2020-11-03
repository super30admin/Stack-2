class Solution {
    
    // Obs: Taking output array of size n is important here, for adding as and when time period is calcualted for an ID.
    //     stack -> for storing the IDs --> maintaining the order
    
    // Obs2: 1:starts:2 ==> prev will be curr only, while for
        //   1:ends:2 ==> prev will be 2+1 = 3
    
    // TC: O(n)
    // SC: O(n)
    public int[] exclusiveTime(int n, List<String> logs) {
        
        if(logs == null || logs.size() == 0 || n <= 0)
            return new int[0];
        
        Stack<Integer> stack = new Stack<>();   // For function ID
        int[] output = new int[n];              // For timestamp
        
        int curr = 0, prev = 0;
        for(String log : logs){
            String[] record = log.split(":");
            
            curr = Integer.parseInt(record[2]);
            if(record[1].equals("start")){
                if(!stack.isEmpty()){
                    output[stack.peek()] += curr - prev;
                }
                stack.push(Integer.parseInt(record[0]));
                prev = curr;
            }else {
                output[stack.pop()] += curr - prev + 1;               
                prev = curr + 1;     // ends at 5 ==> next will start at 6
            }
        }
        return output;
    }
}