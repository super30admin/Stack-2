//Time Complexity : O(n)
//Space Complexity : O(n)

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        
        
        Stack<Integer> stack = new Stack<Integer>();
        int[] result = new int[n];
        String str = logs.get(0);

        String[] strArray = str.split(":");
        int id = Integer.parseInt(strArray[0]);
        stack.push(id);
        int prev = Integer.parseInt(strArray[2]);
        for(int index = 1 ; index < logs.size();index++){
           String log =   logs.get(index);
           String[] logArray = log.split(":");
           id = Integer.parseInt(logArray[0]);
           String function =  logArray[1];
           int cur = Integer.parseInt(logArray[2]);
           if(function.equals("start")){
            if(!stack.isEmpty())   
             result[stack.peek()]+=cur-prev;
            stack.push(id);
            prev = cur;
           }
            else{
                
                if(!stack.isEmpty())
                    result[stack.peek()]+=cur-prev+1; 
                stack.pop();
                prev = cur+1;
            }
            
        }
        
        return result;
        
    }
}
