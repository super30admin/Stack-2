class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        
		//Time: O(n)
		//Space: O(n)
        Stack funcStack = new Stack();
        
        //A variable for staring the last end time
        
        int prevTimeStamp = 0;
        
        String prevType = null;
        
        //an output array to hold the output
        
        int[] output = new int[n];
        
        //push the first task from logs on stack.
        
         
        //run a loop until the logs are over
        
        for(int i = 0; i < logs.size(); i++){
            
            String[] logParts = logs.get(i).split(":");
            
            int taskID = Integer.parseInt(logParts[0]);
            
            String type = logParts[1];
            
            int timeStamp = Integer.parseInt(logParts[2]);
            
            if(type.equals("start")){
                
                int prevTaskID = 0;
                //int duration = 0;
                
               /* if(prevType != null && prevType.equals("start")){
                     duration = timeStamp - prevTimeStamp  ;
                output[prevTaskID] = output[prevTaskID] + duration;
                }
                
                if(prevType != null && prevType.equals("end")){
                    duration = timeStamp - prevTimeStamp -1;
                    output[prevTaskID] = output[prevTaskID] + duration;
                }*/
                
                if(!funcStack.isEmpty()){
                    
                    String prevLog = (String)funcStack.peek();
                    String[] prevLogParts = prevLog.split(":");
                    prevTaskID = Integer.parseInt(prevLogParts[0]);
                    
                }
                
                 //duration =   ;
                output[prevTaskID] = output[prevTaskID] + timeStamp - prevTimeStamp;
               
                funcStack.push(logs.get(i));
                prevTimeStamp = timeStamp;
                prevTaskID = taskID;
                
            }
            
            if(type.equals("end")){
                
                int duration = 0;
                /*if(prevType.equals("start")){
                    duration = timeStamp - prevTimeStamp + 1;
                }
                
                else{
                    duration = timeStamp - prevTimeStamp;
                }*/
                
                String popped = (String)funcStack.pop();
                duration = timeStamp - prevTimeStamp + 1 ;
                output[taskID] = output[taskID] + duration;
                
                prevTimeStamp = timeStamp + 1;
                
            }
            
            //prevTimeStamp = timeStamp;
            
            prevType = type;
        }
        
        return output;
        
    }
}