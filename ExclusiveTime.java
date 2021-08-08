// Time Complexity : O(n)
// Space Complexity : O(n)

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        if(logs == null || logs.size() == 0)
            return res;
        int prev = 0;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < logs.size(); i++){
            String[] str = logs.get(i).split(":");
            int id = Integer.parseInt(str[0]);
            int cur = Integer.parseInt(str[2]);
            if(str[1].equals("start")){
                if(!st.isEmpty()){
                    res[st.peek()] += cur - prev;
                    prev = cur;
                }
                st.push(id);
            }
            else{
                res[st.pop()] += (cur - prev ) + 1;
                prev = cur + 1;
            }
        }
        return res;
    }
}