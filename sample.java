// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//Exclusive Time of Functions
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];
        int prev = 0;
        for(String log : logs){
            String[] splitlog = log.split(":");
            int curr = Integer.parseInt(splitlog[2]);  //start time is in the 2nd index
            int task = Integer.parseInt(splitlog[0]); //this is the task number
            if(splitlog[1].equals("start")){
                //pause the previous stask and store it in the stack
                //curr will be curr
                if(!st.isEmpty()){
                    result[st.peek()]+= curr - prev;
                    
                }
                st.push(task);
                prev = curr;
            }
            else{
                //we are doing +1 in curr because it is towards the latter end of the time 
                result[st.pop()]+= curr + 1 - prev; //storing the time for the particular task 
                prev = curr + 1;
            }
        }

        return result;
        
    }
}

//Valid Paranthesis
class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0) return true;
        if(s.length() == 1) return false;
        Stack<Character> st = new Stack<>();
        for(int i = 0 ; i < s.length() ;i++){
            char ch = s.charAt(i);
            if(ch == '('){
                st.push(')');
            }
            else if(ch == '{'){
                st.push('}');
            }
            else if(ch == '['){
                st.push(']');
            }
            else if(st.isEmpty() || ch!=st.pop()) return false;
        }

        return st.isEmpty();
        
    }
}