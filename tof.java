// TC=SC= O(n)
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if(logs==null) return new int[0];
        
        int result[]= new int[n];
        int prev=0;
        Stack<Integer> st = new Stack<>();
        
        for(String s: logs){
            String []strArr= s.split(":");
            int curr= Integer.parseInt(strArr[2]);
            int task= Integer.parseInt(strArr[0]);
            //start
            if(strArr[1].equals("start")){
                if(!st.isEmpty())
                    result[st.peek()]+= curr-prev;
                prev=curr;
                st.push(task);
            }else{
                //end
                result[st.pop()]+= curr+1-prev;
                prev=curr+1;
            }
        }
        
        return result;
    }
}
