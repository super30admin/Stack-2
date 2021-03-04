class ExclusiveTime {
  
    /*
      Time : O(N) | length of logs List
      Space : O(N) | Stack space
      Leetcode : yes
    */
  
    /*
      Since execution is going to be simultaneous (stack manner) , we can use stack to hold information about it's last running time,
      So when we hit "Start" all we are doing is, 
          - If stack is empty then we are simply adding current process id to the stack,
          - If stack is not empty that means last process ran for some time, 
              - to calculate that time we are adding (current time - prev) process end time to the result array
              - so if we come across same process id again in future we can still update it's running time.
          - IF it's an end time, then 
              - we need to add +1 to curr and store it in a results array. and pop it from stack is that process has ended.
    */
    public int[] exclusiveTime(int n, List<String> logs) {
        // push items in stack,
        // if it's start -> 
        // result += curr - prev;
        // prev = curr;
        // end ->
        // result = curr + 1 - prev;
        Stack<Integer> stk = new Stack<>();        
        int prev = 0;
        int [] result = new int[n];
        
        for(String s : logs){
            String[] splitted = s.split(":");
            int curr = Integer.parseInt(splitted[2]);
            
            if(splitted[1].equals("start")){
                 if(!stk.isEmpty()){                
                    result[stk.peek()] += curr - prev;
                    prev = curr;
                }
                stk.push(Integer.parseInt(splitted[0]));            
            }else{
                result[stk.pop()] += curr + 1 - prev;
                prev = curr +1;
            }
                        
        }
        
        return result;
    }
}
