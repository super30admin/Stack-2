class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int prev=0;
        int curr=0;
        
        Stack<Integer> stk=new Stack<>();
        int[] result = new int[n];
        for (String s:logs) {
            String[] record=s.split(":");
            curr=Integer.parseInt(record[2]);
            
            //start
            if (record[1].equals("start")) {
                if (!stk.isEmpty()) {
                    result[stk.peek()]+=curr-prev;
                }
                stk.push(Integer.parseInt(record[0]));
                prev=curr;
            } else { //end
                result[stk.peek()]+=curr-prev+1;
                stk.pop();
                prev=curr+1;
            }
        }
        
        return result;
    }
}