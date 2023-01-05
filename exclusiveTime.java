// Time Complexity : O(n)
// Space Complexity :O(n)
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if(n==0) return new int[]{};
        int[] res=new int[n];
        int prev=0;
        Stack<Integer> stack=new Stack<>();
        for(String str:logs){
            String[] strArray=str.split(":");
           
            int cur=Integer.parseInt(strArray[2]);
            String op= strArray[1];
            if(op.equals("start")){
                int func=Integer.parseInt(strArray[0]);
                if(!stack.isEmpty()){
                    res[stack.peek()]+=cur-prev;
                }
                prev=cur;
                stack.push(func);
                
            }else{
                res[stack.pop()]+=cur+1-prev;
                prev=cur+1;
            }
        }
        return res;
    }
}