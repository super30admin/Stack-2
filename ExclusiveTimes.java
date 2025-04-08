class ExclusiveTimes {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        int cur=0;
        int prev=0;
        Stack<Integer> st = new Stack<>();
        for(String log: logs)
        {
            String[] strArr = log.split(":");
            int taskId = Integer.parseInt(strArr[0]);
            cur = Integer.parseInt(strArr[2]);
            if(strArr[1].equals("start"))
            {
                if(!st.isEmpty())
                {
                    res[st.peek()] += cur-prev;
                }
                st.push(taskId);
                prev =cur;
            }
            else{
                int poppedTask = st.pop();
                res[poppedTask] += (cur+1)-prev;
                prev =cur+1;
            }
        }
        return res;
    }
}

//Time Complexity: O(L), where L is the number of logs.

//Space Complexity: O(n), where n is the number of tasks.