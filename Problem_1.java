// Time Complexity : O(max(n,m)), m = logs.size();
// Space Complexity :O(max(n,m)), m = logs.size();
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// take stack to store the logs index, and previous to store the last timestamp and current to store the current timestemp, the go through the list and calculate the values,
// if start then prev = curr, result = curr - prev and if end then prev = curr + 1, result = curr + 1 - prev.
// Your code here along with comments explaining your approach
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        // null
        if( logs == null || logs.size() == 0) return new int [n];
        int []  result = new int [n];
        Stack<Integer> st = new Stack<>();
        int prev = 0;
        for( int i = 0; i < logs.size(); i++ ){
            String [] log = logs.get(i).split(":");
            int curr = Integer.parseInt(log[2]);
            if(log[1].equals("start")){
                if(!st.isEmpty()){
                    result[st.peek()] += curr - prev;
                }
                prev = curr;
                st.push(Integer.parseInt(log[0]));
            }else{
                result[st.pop()] += curr + 1  - prev;
                prev = curr + 1;
            }
        }
        return result;
    }
}