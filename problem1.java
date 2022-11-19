package Stack-2;

public class problem1 {
    class Solution {
        //TC:-O(n)
        //SC:- O(n)
        public int[] exclusiveTime(int n, List<String> logs) {
            if(n == 0) return new int[] {};
            
            int curr = 0, prev = 0;
            Stack<Integer> st = new Stack<>();
            int[] result = new int[n];
            
            for(String log : logs){
                String[] strArray = log.split(":");
                curr = Integer.parseInt(strArray[2]);
                
                if(strArray[1].equals("start")){
                    if(!st.isEmpty()){
                        result[st.peek()] += curr - prev;
                    }
                    int functionID = Integer.parseInt(strArray[0]);
                    st.push(functionID);
                    prev = curr;
                }
                else{
                    result[st.pop()] += curr - prev + 1;
                    prev = curr + 1;
                }
            }
            
            return result;
            
        }
    }
}
