//TIme Complexity : O(n) n is the numberof elements in T
//Space Complexity : O(n) since I'm using stack
// LeetCode : passed all tests.


class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        if(n == 0 || logs == null || logs.size() == 0) return result;
        int prev = 0;
        Stack<Integer> st = new Stack<>();
        for(String s : logs){
            String[] str = s.split(":");
            int index = Integer.parseInt(str[0]);
            String action = str[1];
            int time = Integer.parseInt(str[2]);
            if(action.equals("start")){
                if(!st.isEmpty()){
                    result[st.peek()] += time - prev;
                    prev = time;
                }
                
                st.push(index);
            }
            else if(action.equals("end")){
                
                 if(!st.isEmpty()){
                    result[st.pop()] += time - prev +1;
                    prev = time + 1;
                }
                
            }
            
            
        }
        
        return result;
        
    }
}