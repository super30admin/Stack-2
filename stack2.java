//problem1
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> st=new Stack<>();
        int[] res=new int[n];
        int prev=0;
        for(String log:logs){
            String[] split=log.split(":");
            int starting=Integer.parseInt(split[0]);
            int curr=Integer.parseInt(split[2]);
            if(split[1].equals("start")){
                if(!st.isEmpty()){
                    res[st.peek()]+=curr-prev;
                }
                st.push(starting);
                prev=curr;
            }else{
                int popi=st.pop();
                res[popi]+=curr+1-prev;
                prev=curr+1;
            }
        }
        return res;
    }
}
//problem2
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                st.push(')');
            }else if(ch=='{'){
                st.push('}');
            }else if(ch=='['){
                st.push(']');
            }
             else if(st.isEmpty()||st.pop()!=ch) return false;
        }
        return st.isEmpty();
    }
}
