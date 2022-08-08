
//Valid Parenthesis
// Time Complexity :O(n)
// Space Complexity :O(logn)(worst case n/2 will be in satck.
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
// Your code here along with comments explaining your approach: Here we need check whether the given string contains valid
//Parenthesis. Here we will check whether it is opening or closing brace, if its opening then we will push its respective
//closing into the stack. if its closing then we will pop the top of the stack and will check if its eqal to the closing
// brace we are getting.Then we will return

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='(') st.push(')');
            else if(c=='{') st.push('}');
            else if(c=='[') st.push(']');
            else if(st.isEmpty() || c!=st.pop()) return false;
        }
        if(!st.isEmpty()) return false;
        return true;
    }
}
//636. Exclusive Time of Functions
// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: Here we will split the string into the String Array with
//id,start/end,starting/closing time. If its start then we will check whether our stack is empty or not . If its empty then
// we will push that item into that stack.else we will add that time(ie curr-prev) to the result array with that id as index.
//if its end then we will pop the top of the stack and take the top as the index and we will add the time difference to the
//result array.


class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int [] result = new int[n];
        int prev=0;
        Stack<Integer> st=new Stack<>();
        for(String log:logs){
            String [] strArr= log.split(":");
            int curr= Integer.parseInt(strArr[2]);
            if(strArr[1].equals("start")){
                //pause the already started
                if(!st.isEmpty()){
                    result[st.peek()]+=curr-prev;
                    prev=curr;
                }
                st.push(Integer.parseInt(strArr[0]));
            }
            else{
                result[st.pop()]+=curr+1-prev;
                prev=curr+1;
            }
        }
        return result;
    }
}