import java.util.List;
import java.util.Stack;

/***
 TC - O(len(log))
 SC - O(len(log))
 */
class ExclTimeOfFunc {
    public int[] exclusiveTime(int n, List<String> logs) {
        if(logs == null || logs.size() == 0) {
            return new int[]{};
        }

        int[] result = new int[n];
        int curr = 0;
        int prev =0;
        Stack<Integer> st = new Stack<>();

        for(String log : logs) {
            String str[] = log.split(":");
            int id = Integer.parseInt(str[0]);
            String action = str[1];
            curr = Integer.parseInt(str[2]);

            if(action.equals("start")) {
                if(!st.isEmpty()) {
                    result[st.peek()] += curr - prev;
                }
                st.push(id);
                prev = curr;
            }
            else {
                //action-end, pop from stack
                if(!st.isEmpty()) {
                    result[st.pop()] += curr+1 - prev;
                }

                prev = curr+1;
            }
        }

        return result;

    }
}