/**
 * Time Complexity:  O(n)  where n is the number of threads
 * Space Complexity: O(n) size of the stack
 */
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];
        int prev = 0;
        for (int i = 0; i < logs.size(); i++) {
            String[] splitArr = logs.get(i).split(":");
            int id = Integer.parseInt(splitArr[0]);
            int curr = Integer.parseInt(splitArr[2]);
            String action = splitArr[1];

            if (action.equals("start")) {
                if(!st.isEmpty()){
                    result[st.peek()] += curr - prev;
                }
                st.push(id);
                prev = curr;
            } else {
                if (!st.isEmpty() && id == st.peek()) {
                    result[id] += curr + 1 - prev;
                    prev = curr + 1;
                    st.pop();
                }
            }
        }

        return result;

    }
}