// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
//Approach : Keep calculating the time taken by prev task when a new task starts.

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int prev = 0;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        for(String log : logs){
            String[] strArr = log.split(":");
            int currTask = Integer.parseInt(strArr[0]);
            int currTime = Integer.parseInt(strArr[2]);

            if(strArr[1].equals("start")){
                //update time taken by prev task
                if(!st.isEmpty()){
                    result[st.peek()] += currTime - prev;
                }

                st.push(currTask);
                prev = currTime;
            }
            else{
                result[st.pop()] += currTime+1 - prev; //effective end time is +1
                prev = currTime+1;
            }


        }

        return result;
    }
}