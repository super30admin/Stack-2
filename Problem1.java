// Time Complexity : o(max(n,logscount))
// Space Complexity : o(max(n,logscount))
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if(logs ==null || logs.size() == 0)return new int[n];
        //creating a new array with no.of diff processess 
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        int prev =0;
        for(String log : logs){
            String[] splitArr = log.split(":");
            int curr = Integer.parseInt(splitArr[2]);
            if(splitArr[1].equals("start")){
                if(!st.isEmpty()){
                    //if it is the start process we just do curr - prev
                  result[st.peek()] += curr - prev;
                }
                prev = curr;
                st.push(Integer.parseInt(splitArr[0]));
            }
            else{
                //as it is end we need to consider +1 as we have reached the end we need to consider that part as well 
                result[st.pop()] += curr + 1 - prev;
                prev = curr+1;
            }
        }
        return result;
    }
}