//Time Complexity: O(m) where m is the number of logs.
//Space Complexity: O(m) result array of size n plus a stack up to the call depth

// Keep a stack of active function IDs and a prev timestamp marking the start of the current slice.
// On "start": if a function is running, add curr - prev to its time; push new ID; set prev = curr.
// On "end": increment curr (inclusive end), add curr - prev to the top ID, pop it, and set prev = curr.

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];
        int prev = 0;

        for(String log : logs){
            String[] splitArr = log.split(":");
            int processId = Integer.parseInt(splitArr[0]);
            String processType = splitArr[1];
            int curr = Integer.parseInt(splitArr[2]);

            if(processType.equals("start")){
                if(!st.isEmpty()){
                    result[st.peek()] += curr - prev;
                }
                st.push(processId);
            }else{
                curr = curr + 1;
                result[st.pop()] += curr - prev;
            }

            prev = curr;
        }

        return result;
    }
}
