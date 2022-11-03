class Solution {
    //tc-o(n) sc- o(n)
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        if(logs == null || logs.size() == 0) return result;
        Stack<Integer> st = new Stack<>();
        int prev =0;
        for(String log : logs)
        {
            String[] strArr = log.split(":");//[0,start,0]
            int task = Integer.parseInt(strArr[0]);
            int curr = Integer.parseInt(strArr[2]);
            //start
            if(strArr[1].equals("start"))
            {
                if(!st.isEmpty())
                {
                    result[st.peek()]+= curr - prev;
                }
                    prev = curr;
                    st.push(task);
            }
            //end
            else
            {
                result[st.pop()]+= (curr+1) - prev;
                prev = curr+1;
            }
        }
        return result;
    }
}