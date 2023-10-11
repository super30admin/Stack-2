// TC : O(n)
// SC : O(n)
class Solution {

    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];
        int prev = 0;
        int curr = 0; 

        for(String log : logs){
            String[] splitArr = log.split(":");
            curr = Integer.parseInt(splitArr[2]);
            int task = Integer.parseInt(splitArr[0]);

            if(splitArr[1].equals("start")){
                // pausing prev task
                // record time
                if(!st.isEmpty()){
                    result[st.peek()] += curr -prev;

                }
                st.push(task);
                prev = curr;
            }else{
                result[st.peek()] += curr + 1 - prev; 
                st.pop();
                prev = curr +1;
            }

        }
        return result;
    }
}