// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution1 {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        int curr = 0;
        int prev = 0;
        for(String log: logs) {
            String[] log_arr = log.split(":");
            int currTask = Integer.parseInt(log_arr[0]);
            curr = Integer.parseInt(log_arr[2]);
            if( log_arr[1].equals("start") ) {
                if( !st.isEmpty() ) {
                    result[st.peek()] += curr - prev;
                }
                st.push(currTask);
                prev = curr;
            } else {
                result[st.peek()] += curr+1-prev;
                st.pop();
                prev = curr+1;
            }
        }
        return result;
    }
}