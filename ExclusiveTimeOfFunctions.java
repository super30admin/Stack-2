//TC:O(n) whre n is the length of logs list
//SC:O(n)

//Code:

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if(logs ==  null) return new int[0];
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();   //for storing tasks
        int prev =0;
        int curr =0;
        for(String log : logs){
            String[] strArr = log.split(":");  //splitting each log
            curr = Integer.parseInt(strArr[2]);
            if(strArr[1].equals("start")){
                if(!st.isEmpty()){
                    result[st.peek()]+=curr-prev;
                }
                st.push(Integer.parseInt(strArr[0]));
                prev=curr;
            }else{
                result[st.pop()]+= curr-prev+1;
                prev=curr+1;
            }
        }
        return result;
    }
}