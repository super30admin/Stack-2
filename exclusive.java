class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int []result = new int[n];
        Stack<Integer> st = new Stack<>();
        int curr =0;
        int prev = 0;
        for(String log: logs){
            String [] strArr = log.split(":");
            int currTask = Integer.parseInt(strArr[0]);
            curr = Integer.parseInt(strArr[2]);
            if(strArr[1].equals("start")){
                if(!st.isEmpty()){
                    result[st.peek()] += curr- prev;
                }
                st.push(currTask);
                prev = curr;
            }else{
                result[st.pop()] += curr+1 - prev;
                 prev = curr+1;
            }
        }
        return result;
    }
}