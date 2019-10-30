// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : 
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public boolean isValid(String s) {
        if(s=="") return true;
        Stack<Character> st = new Stack<Character>();
        HashMap<Character,Character> map = new HashMap<Character, Character>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==')' || s.charAt(i)==']' || s.charAt(i)=='}'){
                if(st.isEmpty()) return false;
                char popped = st.pop();
                char mapValue = map.get(s.charAt(i));
                if(popped!=mapValue) return false;
            }
            else {
                st.push(s.charAt(i));
            }
        }
        if(!st.isEmpty()) return false;
        return true;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(n)
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> st = new Stack<Integer>();
        int[] res = new int[n];
        int prev = 0;
        
        for(String log: logs){
            String[] str = log.split(":");
            int curr = Integer.parseInt(str[2]);
            if(str[1].equals("start")){
                if(!st.isEmpty()){
                    res[st.peek()] += curr - prev;
                }
                st.push(Integer.parseInt(str[0]));
                prev = Integer.parseInt(str[2]);
            }
            else{
                res[st.peek()] += curr - prev+1;
                st.pop();
                prev = curr+1;
            }
        }
        return res;
    }
}
