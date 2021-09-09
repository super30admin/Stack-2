class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {

        int[] ans = new int[n];
        int prev = 0;
        Stack<Integer> st = new Stack<>();


        for(String log : logs)
        {
            String[] lg = log.split(":");

            if(lg[1].equals("start"))
            {
                if(!st.isEmpty()) ans[st.peek()] += Integer.valueOf(lg[2])-prev;
                st.push(Integer.valueOf(lg[0]));
                prev = Integer.valueOf(lg[2]);
            }
            else
            {
                if(!st.isEmpty()) ans[st.peek()] += Integer.valueOf(lg[2])-prev+1;
                st.pop();
                prev = Integer.valueOf(lg[2]) + 1;
            }
        }

        return ans;
    }
}
