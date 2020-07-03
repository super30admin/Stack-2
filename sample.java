// PRoblem -1:exclusive-time-of-functions
// TC = O(n) where n is num of logs
// SC = O(n/2) stack space

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if(logs == null || logs.size() == 0) return new int[0];
        
        Stack<Integer> s = new Stack<>();
        int[] result = new int[n];
        int prev = 0;
        for(String log: logs){
            
            String[] logArr = log.split(":"); // [id][status][curTime]
            int cur = Integer.parseInt(logArr[2]);
            int curId = Integer.parseInt(logArr[0]);
            String status = logArr[1];
            
            if(status.equals("start")){
                
                if(!s.isEmpty()){
                    result[s.peek()] += cur - prev;
                }
                    s.push(curId);
                    prev = cur;
            }else{
                result[s.pop()] += cur + 1 - prev;
                prev = cur+1;
            }
            
        }
        
        return result;
        
    }
}

// PRoblem -2: Valid pranthesis

/**
Putting closing brack in the stack whenever an opening bracket is encountered. If the closing bracket is encountered it is matched with the closing bracket on the top of the stack to check the validity of the string
TC = O(n) where n is num of chars in the string s
SC = O(n)
*/
class Solution {
    public boolean isValid(String s) {
        
        if(s == null || s.length() == 0) return true;
        
        Stack<Character> st = new Stack<>();
        
        for(int i=0; i< s.length(); i++){
            
            Character cur = s.charAt(i);
            
            if(cur == '('){
                st.push(')');
            }else if( cur == '{'){
                st.push('}');
            }else if( cur == '['){
                st.push(']');
            }else{
                if(st.isEmpty() || cur != st.pop()) return false;
            }
        }
        
        
        
        return st.isEmpty(); // if there is a lefotover bracket in the stack, then the string is invalid
        
        
    }
}
