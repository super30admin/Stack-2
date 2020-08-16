//O(n)
//O(n)
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        int prev = 0;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<logs.size();i++){
             String[] log = logs.get(i).split(":");
            int task = Integer.parseInt(log[0]);
            int curr = Integer.parseInt(log[2]);
             if(log[1].equals("start")){
                 if(!st.isEmpty()){
                     res[st.peek()] += curr-prev;
                 }
                 st.push(task);
                 prev = curr;
             }else{
                 res[st.pop()]+=curr-prev+1;
                 prev = curr+1;
             }

        }
        return res;
    }
}
