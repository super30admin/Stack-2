class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if( n==0 || logs.size() == 0) return new int[]{};
        
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];
        
        int prev =0;
        int curr =0;
        
        for(String lg : logs)
        {
            String[] log = lg.split(":");
            
            //extract the id, and timestamp
            int id = Integer.parseInt(log[0]);
            curr =  Integer.parseInt(log[2]);
            
            //start scenario
            if(log[1].equals("start")) {
                if(!st.isEmpty()) {         //bfore peeking check if stack is not empty
                    int oldId = st.peek();
                    result[oldId] += curr-prev;
                }
                st.push(id);
            }else //end
            {
                curr = curr +1;
                result[st.pop()] += curr- prev;
            }
            prev = curr;
        }
        return result;
    }
}
