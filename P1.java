//time complexity:o(n)

//space complexity :o(n)

//idea is to store function id in stack and it's corresponding time in result array.

//compute time by subtracting current time from previous time.

//if function is "start" then time is curr - prev  and prev is set to curr. function start at begining of timestamp.

//if funtion is "end" then time is curr - prev +1 and prev is set to curr +1 because function is ending at the end of timestamp so other process cant start at same curr time.

//note we can not use hashmap because here function order of function is important and according to order time needs to be added.["0:start:0","1:start:2","1:end:5","0:end:6"]

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        int curr = 0; int prev = 0;
        for (String log : logs) {
            String[] strArr = log.split(":");
            int taskId = Integer.parseInt(strArr[0]);
            curr = Integer.parseInt(strArr[2]);
            if (strArr[1].equals("start")) {
                //start log
                if (!st.isEmpty()) {
                    result[st.peek()] += curr - prev;
                }
                st.push(taskId);
                prev = curr;
            } else {
                int poppedTask = st.pop();
                result[poppedTask] += curr + 1 - prev;
                prev = curr + 1;
            }
        }
        return result;
    }
}
