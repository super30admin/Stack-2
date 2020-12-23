//Time complexity:O(n)
//space complexity:O(n)

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer>st=new Stack<>();
        int result[]=new int[n];
        //int curr=0;
        int prev=0;
        for(String log:logs)
        {
            String[] slog=log.split(":");
             int curr=Integer.parseInt(slog[2]);
            if( slog[1].equals("start"))
            {
                if(!st.isEmpty())
                {
                    result[st.peek()]+=curr-prev;
                    prev=curr;
                }
                 st.push(Integer.parseInt(slog[0]));
            }
            else
            {
                result[st.pop()]+=curr-prev+1;
                prev=curr+1;
            }
           
        }
        return result;
    }
}
