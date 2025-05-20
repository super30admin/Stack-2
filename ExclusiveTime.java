// Time complexity :O(n);
// Space Complexity :O(n);
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int prev = 0, curr = 0;
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];
        for (String log : logs) {
            String[] strArr = log.split(":");
            int taskId = Integer.parseInt(strArr[0]);
            curr = Integer.parseInt(strArr[2]);
            if (strArr[1].equals("start")) {
                if(!st.isEmpty()){
                    result[st.peek()]+= curr -prev;
                }
                st.push(taskId);
                prev = curr;
            }
            else {
                int popped = st.pop();
                result[popped] += curr +1 -prev;
                prev = curr+1;
            }
        }
        return result;

    }
}