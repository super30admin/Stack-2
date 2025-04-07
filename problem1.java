//636. Exclusive Time of Functions
//Time Complexity: O(n)
//Space Complexity: O(n)

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];
        int curr=0; int prev=0;
        for(String log: logs){
            String [] strArr = log.split(":");
            int taskId = Integer.parseInt(strArr[0]);
            curr = Integer.parseInt(strArr[2]);
            if(strArr[1].equals("start")){
                //strat log
                if(!st.isEmpty()){
                    result[st.peek()] += curr-prev;
                }
                st.push(taskId);
                prev=curr;
            }else{
                int poppedTask = st.pop();
                result[poppedTask] += curr +1 - prev;
                prev = curr+1;
            }
        }
        return result;
    }
}