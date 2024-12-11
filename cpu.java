class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> st = new Stack<>();
        int[] res=new int[n];
        int prev=0;
        for(String log:logs){
            String[] logsp=log.split(":");
            int id = Integer.parseInt(logsp[0]);
            String type=logsp[1];
            int curr=Integer.parseInt(logsp[2]);
            if(type.equals("start")){
                if(!st.isEmpty()){
                    res[st.peek()]+=curr-prev;
                }
                st.push(id);
            }
            else{
                curr++;
                res[st.pop()]+=curr-prev;
            }
            prev=curr;
        }
        return res;
    }
}
