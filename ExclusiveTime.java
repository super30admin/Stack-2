//o(n) time and space (n is length of token array)
//passed all leetcode cases
//used stack approach

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];
        int prior=0, current=0;
        for(String log:logs){
            String[] token = log.split(":");
            int funId = Integer.parseInt(token[0]);
            current = Integer.parseInt(token[2]);
            if(token[1].equals("start")){
                if(!stack.isEmpty()){
                    result[stack.peek()] += current - prior;

                }
                stack.push(funId);
                prior = current;
            }else{
                result[funId]+=current - prior+1;
                stack.pop();
                prior = current+1;
            }
        }
        return result;
    }
}