/*
TC: O(n) n: no of logs.
SC: O(n) n: no of logs.
Approach: Using Stack to keep track of the functions running. at each function call i take the diff between already running function and the one called which is been added to the result of already running function. add the currlog to the stack and update the prev which would be the start time of currLog. If End, then same thing as start but add 1 as the time is inclusive.for prev also we add 1.At the end, return result;
 */

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        String[] currLog = logs.get(0).split(":");
        int prev = Integer.parseInt(currLog[2]);
        st.push(Integer.parseInt(currLog[0]));

        for(int i =1; i< logs.size(); i++){
            currLog = logs.get(i).split(":");

            if(currLog[1].equals("start")){
                if(!st.isEmpty()){
                    result[st.peek()] += Integer.parseInt(currLog[2]) - prev; 
                }
                st.push(Integer.parseInt(currLog[0]));
                prev = Integer.parseInt(currLog[2]);
            }else{
                result[st.peek()] += 1 + Integer.parseInt(currLog[2]) - prev;
                st.pop(); 
                prev = 1 + Integer.parseInt(currLog[2]);
            }
        } 
     return result;   
    }
}