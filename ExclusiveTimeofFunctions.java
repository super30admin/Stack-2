public class ExclusiveTimeofFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        // null case
        if(logs==null) return new int[0];
        Stack<Integer> st = new Stack<>();
        int prev = 0;
        int[] result = new int[n];
        for(String log:logs){
            String[] strArr = log.split(":"); //[taskId,"start",startTime]
            // start
            int curr = Integer.parseInt(strArr[2]);
            if(strArr[1].equals("start")){
                if(!st.isEmpty()) result[st.peek()] += curr-prev;
                prev = curr;
                st.push(Integer.parseInt(strArr[0]));
            }else{ //end
                result[st.pop()] += (curr+1)-prev;
                curr = Integer.parseInt(strArr[2]);
                prev = curr+1;
            }            
        }
        return result;
    }
}

// Time Complexity - O(n)
// Space Complexity - O(n)