
// Time Complexity : O(N) N:log size
// Space Complexity : O(N) stack - N/2 
// Any problem you faced while coding this :
 /* 
 Stack
 1. Push(function) if start and pop if end 
 2. Store the time interval in resultant array while push/pop
 */
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if(logs == null || logs.size()==0) return new int[0];
        
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];
        
        int prev = 0;
        int curr = 0;
        
        for(int i=0; i<logs.size();i++){
            String s = logs.get(i);
            String[] logArray = s.split(":");
            curr = Integer.parseInt(logArray[2]);
            if(logArray[1].equals("start")){
                if(!st.isEmpty()){
                     result[st.peek()]  = result[st.peek()] + curr-prev;
                }
                st.push(Integer.parseInt(logArray[0]));
                prev = curr;
            }
            else{
                result[st.peek()] = result[st.peek()] +  curr-prev+1;
                prev = curr+1;
                st.pop();
            }
        }
        
        return result;
        
    }
}