//Time Complexity : O(n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode :yes
//Any problem you faced while coding this : no
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        
        Stack<Integer> s1 = new Stack<>();
        int[] result = new int[n];
        int prev = 0;
        
        
        for(String log : logs){
            
            String[] str = log.split(":");
            int curr = Integer.parseInt(str[2]);
            
            if(str[1].equals("start")){
                int temp = Integer.parseInt(str[0]);
                if(!s1.isEmpty()){
                    
                result[s1.peek()] = result[s1.peek()] + curr - prev;
                prev = curr;
                    
                }
                
                s1.push(temp);
                
            }
            
           else if(str[1].equals("end")){
               
                result[s1.peek()] = result[s1.peek()] + curr - prev + 1;
                prev = curr + 1;
                s1.pop();
                
                
            }
        }
        return result;
    }
}