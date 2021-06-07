//Time Complexity:O(n)
//Space Complexity:O(n)
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        int prev=0;
        for(String log : logs){
            String[] each = log.split(":");
            int curr=Integer.parseInt(each[2]);
            if(each[1].equals("start")){
                if(stack.isEmpty()){
                    stack.push(Integer.parseInt(each[0]));
                    prev=curr;
                }
                else{
                    res[stack.peek()]+=curr-prev;
                    stack.push(Integer.parseInt(each[0]));
                    prev=curr;
                }
            }else if(each[1].equals("end") && !stack.isEmpty()){
                    res[stack.pop()]+=curr-prev+1; // +1 beacuse if log starts at 1 and ends at 1 we have 1-1 =0 but we need to add 1 sec
                    prev=curr+1; // it says that, that second is ended
            }
        }
        return res;
    }
}