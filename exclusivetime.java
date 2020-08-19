//Time and space complexity:O(n)
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result=new int[n];
        if(logs==null || logs.size()==0){
            return result;
        }
        Stack<Integer> st=new Stack();
        int prev=0;
        for(String s:logs){
            String[] arr=s.split(":");
            int curr=Integer.parseInt(arr[2]);
            if(arr[1].equals("start")){
                if(!st.isEmpty()){
                    result[st.peek()]+=curr-prev;
                }
                st.push(Integer.parseInt(arr[0]));
                prev=curr;               
            }
            else{
                result[st.pop()]+=curr-prev+1;
                prev=curr+1;
            }
        }
        return result;
    }
}