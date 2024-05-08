class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];
        int prev = 0;
        for(String log : logs){
            String[] splitArr = log.split(":");
            int curr = Integer.parseInt(splitArr[2]);
            int task = Integer.parseInt(splitArr[0]);
            if(splitArr[1].equals("start")){
                if(!st.isEmpty()){
                    result[st.peek()] += curr - prev;
                }
                prev = curr;
                st.push(task);
            }else{
                result[st.pop()] += curr - prev + 1;
                prev = curr + 1;
            }
        }
        return result;
    }
}