class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        int prev = 0, cur = 0;
        
        for(String log : logs){
            String[] splitArray = log.split(":");
            cur = Integer.parseInt(splitArray[2]);
            if(splitArray[1].equals("start")){
                if(!st.isEmpty())
                    res[st.peek()] += cur - prev;
                int func_idx = Integer.parseInt(splitArray[0]);
                st.push(func_idx);
                prev = cur;
            }
            else{
                res[st.peek()] += cur + 1 - prev;
                st.pop();
                prev = cur + 1;
            }
        }
        return res;
    }
}

//Time Complexity : O(n)
//Space Complexity :O(1)