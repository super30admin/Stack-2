//TC - O(length of logs list)
//SC - O(n)
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if(n == 0){
            return new int[]{};

        }
        Stack<Integer>st = new Stack<>();
        int curr = 0;
        int prev = 0;
        int[] result = new int[n];
        for(String log : logs){
            String[] strArray = log.split(":");
            curr = Integer.parseInt(strArray[2]);
            if(strArray[1].equals("start")){
                if(!st.isEmpty()){
                    result[st.peek()] += curr - prev;
                }
                st.push(Integer.parseInt(strArray[0]));
                prev = curr;
            

            }
            else{
                //When end is hit, pop that ID out
                result[st.pop()] += curr + 1 - prev;
                prev = curr + 1;

            }
        }
        return result;
    }
}
