//tc- O(n) sc- O(n/2)

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        int prev = 0;

        for(String log: logs){
            String[] splitArr = log.split(":");
            int processId = Integer.parseInt(splitArr[0]);
            String type = splitArr[1];
            int curr = Integer.parseInt(splitArr[2]);

            if(type.equals("start")){
                //pause the prev process
                if(!st.isEmpty()){
                    //curr = curr
                    result[st.peek()] += curr - prev;
                }
                st.push(processId);
            }else{
                //end the process
                curr = curr + 1;
                result[st.pop()] += curr - prev;
            }
            prev = curr;
        }
        return result;
        
    }
}