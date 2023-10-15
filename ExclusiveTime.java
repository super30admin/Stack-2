//TC = O(n) n is logs length
//SC = O(n) number of tasks. 
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];
        int prev = 0;
        for(String log : logs){
            String[] splitArr = log.split(":"); //[0,start,0]
            int curr = Integer.parseInt(splitArr[2]); // Converting 0 - from string to int
            int task = Integer.parseInt(splitArr[0]);
            if(splitArr[1].equals("start")){
                //pasue prev task in stack
                //record the time
                if(!st.isEmpty()){
                    result[st.peek()] += curr-prev;
                }
                prev = curr;
                st.push(task);
            }else{
                //end log
                //curr = curr+1
                result[st.pop()] += curr+1-prev;
                prev = curr+1;
            }
        }
        return result;
    }
}