Problem 1 Exclusive Time of functions
// Time Complexity :O(n+logs.length)
// Space Complexity :O(n+logs.length/2)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
//check for start and end tasks, then keep a stack for previous task so that next upcoming task will temprarily stop previous task and add task length in resultant array.
// at current task end, check previous start and count upcoming cells for the previous element as it has not ended.
class Solution {
    //O(n+logs.length) //O(n+ logs.length/2)
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> st= new Stack<>();
        int[] res= new int[n];
        int prevTime=0;
        for(String log: logs){
            String[] arr= log.split(":");//"1:end:2"
            int cur=Integer.parseInt(arr[2]);
            int task=Integer.parseInt(arr[0]);

            if("start".equals(arr[1])){
                //cur=cur

                //pause prev task in Stack
                if(!st.isEmpty()){
                    res[st.peek()]+=cur-prevTime;
                }
                st.push(task);
                prevTime=cur;
            }else{
                //cur=cur+1  //whole time limit is completed.
                res[st.pop()]+=cur+1-prevTime;
                prevTime=cur+1;
            }
        }
        return res;
    }
}

Problem 2 Valid parenthesis
// Time Complexity :O(n)
// Space Complexity :O(n/2)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
//for every opening bracket, put in similar closing bracket in stack, when we get closing bracket, check stack.top and return false if not same.
class Solution {
    public boolean isValid(String s) {
        // Stack<Character> stack = new Stack<>();
        // for(char ch: s.toCharArray())
        // {
        //     switch (ch)
        //     {
        //         case '(':
        //         case '{':
        //         case '[':
        //             stack.push(ch);
        //             break;
        //         case ')':
        //             if(stack.isEmpty() || stack.pop() != '(')
        //             {
        //                 return false;
        //             }
        //             break;
        //         case '}':
        //             if(stack.isEmpty() || stack.pop() != '{')
        //             {
        //                 return false;
        //             }
        //             break;
        //         case ']':
        //             if(stack.isEmpty() || stack.pop() != '[')
        //             {
        //                 return false;
        //             }
        //             break;
        //     }
        // }
        // return stack.isEmpty();
        if(s==null || s.length()==0) return true;
        Stack<Character> st= new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('){
                st.push(')');
            }
            else if(c=='{'){
                st.push('}');
            }
            else if(c=='['){
                st.push(']');
            }
            else if(st.isEmpty() || c!=st.pop()){
                return false;
            }
        }
        return st.isEmpty();
    }
}