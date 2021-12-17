class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int [] result = new int[n];
        if(logs == null || logs.size() == 0) return result;
        Stack<Integer> st = new Stack<>();
        int prev = 0;
        for(String log : logs){
            String [] strs = log.split(":");
            int curr = Integer.parseInt(strs[2]);
            if(strs[1].equals("start")){
                if(!st.isEmpty()){
                    result[st.peek()] += curr - prev;
                prev = curr;
                }
                
            
            st.push(Integer.parseInt(strs[0]));
        }else{
            result[st.pop()] += curr + 1 - prev;
            prev  = curr + 1;
        }
        }
        return result;
    }
}

//TC:O(n)
//SC: O(n)
