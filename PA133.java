//Leetcode : 636. Exclusive Time of Functions
//Time complexity:O(n) 
//Space Complexity:O(n), size of the stack
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        if(logs==null || logs.size()==0) return res;        
        Stack<Integer> st = new Stack<>();
        int prev=0;
        for (String s: logs){
            String[] arr = s.split(":");
            int curr= Integer.parseInt(arr[2]);
            if(arr[1].equals("start")){
                if(!st.isEmpty()){
                    res[st.peek()]+=curr-prev;
                }
                
                    prev= curr;
                    st.push(Integer.parseInt(arr[0]));
                
            }
            else{
                    res[st.pop()] +=curr-prev+1; 
                    prev= curr+1;
                
            }
            
        }
        return res;
        
    }
}