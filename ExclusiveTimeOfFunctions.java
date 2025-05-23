// TC: O(L)
// SC: O(n)
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
       Stack<Integer> st = new Stack<>();

       int[] result = new int[n];
       int prev = 0;

       for(String log : logs) {
        String[] splitArr = log.split(":");
        int processId = Integer.parseInt(splitArr[0]);
        String processType = splitArr[1];
        int curr = Integer.parseInt(splitArr[2]);
        

        if(processType.equals("start")) {
            // curr = curr 
            if(!st.isEmpty()) {
                result[st.peek()] += curr-prev;
            } 
            st.push(processId);

        } else {
            curr = curr+1;

            result[st.pop()] += curr - prev;
        }

        prev = curr;
       }
       return result;
    }
}
