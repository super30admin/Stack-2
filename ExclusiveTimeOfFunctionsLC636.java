class Solution {

    //Approach 1
    //Time Complexity: O(n)
    //Space Complexity: O(n)  

    public int[] exclusiveTime(int n, List<String> logs) {
        
        Stack<int[]> stack = new Stack<>();                         //creating a stack
        int[] res = new int[n];                                     // creating the result array
        
        for(String log: logs){                                      //iterating through logs
            
            String[] splits = log.split(":");                       //spliting the log, and extract the functionId, time, and type
            
            int fnId = Integer.parseInt(splits[0]);
            String type = splits[1];
            int time = Integer.parseInt(splits[2]);
            
            if(type.equals("start")){                               //if new function starting,
                
                stack.push(new int[]{fnId, time});                  //them we just push the functionId, and start time of the function into the stack
                
            }
            else{
               
                int startTime = stack.pop()[1];                     //if function is ending, then we extract the start time of that function
                int spentTime = time - startTime + 1;               //calculate the time spent by the function
                res[fnId] += spentTime;                             //and add it to the result
                
                if(!stack.isEmpty()){                               //check if stack is not empty, if so, means that, some other function called this function, so we need to subtract that timing from the function that called this function
                    res[stack.peek()[0]] -= spentTime;
                }
            }   
        }
        return res;
        
    }
    
    
    //Approach 2
    //Time Complexity: O(n)
    //Space Complexity: O(n)

//     public int[] exclusiveTime(int n, List<String> logs) {
        
//         Stack<Integer> stack = new Stack<>();                        //creating the stack
//         int prev = 0;                                                //acting as the start time of the current function
//         int[] res = new int[n];                                      //creating the result array
        
//         for(String log: logs){                                       //itearting through array
            
//             String[] splits = log.split(":");                        //spliting the logs, and extract the functionId, type and time of the function
            
//             int fnId = Integer.parseInt(splits[0]);
//             String type = splits[1];
//             int time = Integer.parseInt(splits[2]);
            
//             if(type.equals("start")){                                //if function is starting then,
                
//                 if(!stack.isEmpty()){                                //check if stack is not empty
//                     res[stack.peek()] += time - prev;                //if stack is not empty, then we update the time spend by the previous function into result array
//                 }
//                 stack.push(fnId);                                    //push the new function into stack
//                 prev = time;                                         //update the start time of current function
//             }
//             else{
//                 res[stack.pop()] += time - prev + 1;                  //if function is ending, means that we have to pop the function and calculate the spent time by this current function and update it to the result
//                 prev = time + 1;
//             }   
//         }
//         return res;
//     }
}
