//https://leetcode.com/problems/valid-parentheses
//Time Complexity = O(N)
//Space Complexity = O(N)

class Solution {
    public boolean isValid(String s) {
        if(s.length() == 0) return true;
        
        Stack<Character> st = new Stack<>(); 
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i); 
            if(c == '(') st.push(')');
            else if(c == '{') st.push('}');
            else if(c == '[') st.push(']'); 
            else if(st.isEmpty() || c != st.pop()) return false;
        }
        if (!st.isEmpty()) return false;
        else return true; 
    }
}

//https://leetcode.com/problems/exclusive-time-of-functions
//Time Complexity = O(N)
//Space Complexity = O(N)
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n]; 
        if(logs.size() == 0) return result;
        Stack<Integer> st = new Stack<>();
        int prev = 0; 
        
        for(String log : logs){
            String[] str = log.split(":");
            int curr = Integer.parseInt(str[2]);
            if(str[1].equals("start")){
                if(!st.isEmpty()){
                    result[st.peek()] += curr - prev;
                    prev = curr;
                }
                st.push(Integer.parseInt(str[0])); 
            }
            else{
                result[st.pop()] += (curr - prev + 1);
                prev = curr + 1;
            }
        }
        return result; 
    }
}
