class Solution {
    //TC:O(n)   SC:O(n)
    public boolean isValid(String s) {
        if(s == null || s.length() == 0)  return true;
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '('){
                st.push(')');
            } else if(c == '{'){
                st.push('}');
            } else if(c == '['){
                st.push(']');
            } else if(st.isEmpty() || st.pop() != c){
                return false;
            }
        }
        return st.isEmpty();
    }

    // TC: O(n)  SC: O(n)
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];
        int prev = 0;
        for(String log : logs){
            String[] splitlog = log.split(":");
            int curr = Integer.parseInt(splitlog[2]);
            int task = Integer.parseInt(splitlog[0]);
            if(splitlog[1].equals("start")){
                if(!st.isEmpty()){
                    result[st.peek()] += curr - prev;
                }
                st.push(task);
                prev = curr;
            } else {
                result[st.pop()] +=  curr + 1 - prev;
                prev = curr + 1;
            }
        }
        return result;
    }
}