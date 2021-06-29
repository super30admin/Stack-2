class ExclusiveTime {
    //time:O(n)
    //space: O(n)
    //did it run successfully on leetcode: yes
    public int[] exclusiveTime(int n, List<String> logs) {
        //stack to store unresolved thread
        Stack<Integer> st = new Stack<>();
        //array to store our result
        int[] res = new int[n];
        //stores previous start or end time
        int prev = 0;
        //looping through the logs
        for(int i=0; i<logs.size(); i++){
            //storing current start or end time, current operation or status and id of function call
            String[] str = logs.get(i).split(":");
            int currVal = Integer.parseInt(str[2]);
            String status = str[1];
            int currId = Integer.parseInt(str[0]);
            
            //if current operation is start
            if(status.equals("start")){
                //if item exist in stack
                if(!st.isEmpty()){
                    //update the top item of stack
                    res[st.peek()] += currVal-prev;
                }
                //add current function call to stack
                st.push(currId);
                //update prev
                prev = currVal;
            }//if current operation is end
            else{
                //get top function call in stack
                int id = st.pop();
                //update result for the above function call
                res[id] += currVal-prev+1;
                //update previous
                prev = currVal+1;
            }
            
        }
        return res;
    }
}