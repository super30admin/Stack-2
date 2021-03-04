//Time Complexity: O(n)
//Space complaxity: O(N)
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int [] result = new int [n];
        if(logs.size() == 0 || logs == null)return result;
        int prev =0;
        Stack<Integer> st = new Stack<>();
        for(String log: logs){
            String[] str = log.split(":");
            int curr = Integer.parseInt(str[2]);
            if(str[1].equals("start")){
                if(!st.isEmpty()){
                    result[st.peek()] += curr-prev;
                    prev = curr;
                }
                st.push(Integer.parseInt(str[0]));
            }else{
                result[st.pop()] += curr+1 - prev;
                prev = curr+1;
            }
        }
        return result;
    }
}