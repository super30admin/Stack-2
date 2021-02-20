// Time, Space - O(N), O(N)
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if(n==0||logs==null||logs.size()==0) {
            return new int[] {};
        }
        Stack<Integer> st = new Stack<>();
        
        int[] result = new int[n];
        int prev = 0;
        for(String log : logs) {
            String[] entry = log.split(":");
            int id = Integer.parseInt(entry[0]);
            String type = entry[1];
            int curr = Integer.parseInt(entry[2]);
            
            if(type.equals("start")) {
                if(!st.isEmpty()) {
                    result[st.peek()] += curr - prev;
                    prev = curr;
                }
                st.push(id);
            }
            else {
                result[st.pop()] += curr - prev + 1;
                prev = curr + 1;
            }
        }
        
        return result;
        
    }
}
