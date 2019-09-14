//Time complexity and Space complexity : 0(n)
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        int [] result = new int[n];
        int prev =0;
        for(String s :logs){
           String[] strs = s.split(":");
            int current = Integer.parseInt(strs[2]);
            if(strs[1].equals("start")){
                if(!stack.isEmpty()){
                    result[stack.peek()]+=current-prev;
                }
                stack.push(Integer.parseInt(strs[0]));
                prev= current;
            }else{
                result[stack.pop()]+=current-prev+1;
                prev=current+1;
            }
        }
        return result;
        
        
    }
}