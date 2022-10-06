O(N) time ans space complexity


class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        int prev =0;
        Stack<Integer> st = new Stack<>();
        for(String log: logs){
            String[] logSplit = log.split(":");
            int func = Integer.parseInt(logSplit[0]);
            int curr = Integer.parseInt(logSplit[2]);
            if(logSplit[1].equals("start")){
                if(!st.isEmpty()){
                    result[st.peek()] += curr-prev;
                }
                prev =curr;
                st.push(func);
            }
            else{
                result[st.pop()] += curr-prev+1;
                prev = curr + 1;
            }
        }
        return result;
    }
}
