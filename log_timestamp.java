/**
LeetCode Submitted : YES
Time Complexity : O(n)
Space Complexity : O(n)


The idea is to split the log timestamp and store the current job in the stack such that at each START position we update result array timestamp. Also, at each "END" command we add the time of the relevant job with the current timestamp - previous recorded timestamp + 1 to get the required result. Here, End timestamp is inclusive.
**/
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        int prev = 0;
        
        Stack<Integer> st = new Stack<>();
        for(String s : logs){
            String[] parse = s.split(":");
            if(parse[1].equals("start")){
                if(!st.isEmpty()){
                        result[st.peek()] = result[st.peek()] + Integer.parseInt(parse[2]) - prev;
                        prev = Integer.parseInt(parse[2]);
                    }
                
                st.push(Integer.parseInt(parse[0]));
            }
            else{
                    result[st.peek()] = result[st.peek()] + Integer.parseInt(parse[2]) - prev + 1;
                    st.pop();
                    prev = Integer.parseInt(parse[2]) + 1;
                }
        }
        return result;
    }
}
