// https://leetcode.com/problems/exclusive-time-of-functions/
// Time complexity : O(len(logs))
// Space complexity : O(len(logs))

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int res[] = new int[n];
        int prev = 0;
        Stack<Integer> st = new Stack<>();
        for(String log : logs){
            String arr[] = log.split(":");
            int id = Integer.parseInt(arr[0]);
            int time = Integer.parseInt(arr[2]);
            if(arr[1].equals("start")){
                if(!st.isEmpty())
                    res[st.peek()] += (time - prev);
                st.push(id);
                prev = time;
            }else{
                res[st.pop()] += (time - prev + 1);
                prev = time+1;
            }
        }
        return res;
    }
}