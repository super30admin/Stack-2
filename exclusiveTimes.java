class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        
        Stack<Integer> st = new Stack<Integer>();
        int[] result = new int[n];
        int prev = 0;
        for(String log:logs){
            String[] strs = log.split(":");
            int curr = Integer.parseInt(strs[2]);
            if(strs[1].equals("start")){
                if(!st.isEmpty()){
                    result[st.peek()] += curr - prev;
                    prev = curr;
                }
                st.push(Integer.parseInt(strs[0]));
            }
            else{
                result[st.pop()] += curr - prev + 1;
                prev = curr + 1;
            }
            
        }
        return result;
    }
}

//Time complexity: O(n)
//Space complexity: O(number of logs)
