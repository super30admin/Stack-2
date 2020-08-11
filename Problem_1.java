// Time complexity - O(n)
// Space complexity - O(n)

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        if(logs== null || logs.size() == 0) return result;
        Stack<Integer> st = new Stack<>();
        int prev = 0;
        for(String log : logs){
            String[] strArr = log.split(":");
            int curr = Integer.parseInt(strArr[2]);
            if(strArr[1].equals("start")){
               if(!st.isEmpty()){
                   result[st.peek()] += curr - prev;
               }
                st.push(Integer.parseInt(strArr[0]));
                prev = curr;
            }else{
                result[st.pop()] += curr - prev + 1;
                prev = curr + 1;
            }
        }
        return result;
    }
}
