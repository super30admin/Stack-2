//Time Complexity: o(n)
//Space Complexity: 0(1)
//Expln: Iterate through the array by storing the start in stack and pop the values in 
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];
        String[] str = new String[3];
        int prev = 0;
        int curr = 0;
        int len = logs.size();
        if(len==0 )
            return result;  
        for(String string: logs)
        {
            str = string.split(":");
            curr = Integer.parseInt(str[2]);
            if(str[1].equals("start"))
            {
                if(!st.isEmpty()){
                result[st.peek()] += curr - prev;
                prev = curr;
                }
                st.push(Integer.parseInt(str[0]));
            }
            else
            {
                result[st.pop()] += curr - prev + 1;
                prev = curr+1;
            }
        }
        return result;
    }
}